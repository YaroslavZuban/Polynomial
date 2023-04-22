import java.util.Map;
import java.util.TreeMap;


public class Poly {
    private TreeMap<Integer, Term> polynomial;

    public Poly() {
        polynomial = new TreeMap<>();
    }

    public Poly(TreeMap<Integer, Term> polynomial) {
        this.polynomial = polynomial;
    }

    public Poly(String polynomial) {
        this.polynomial = new TreeMap<>();
        workingPolynomials(polynomial.toLowerCase());
    }

    private void workingPolynomials(String polynomial) {
        String[] terms = polynomial.split("(?=[-+])");

        for (String term : terms) {
            Term t = parseTerm(term);

            if (t != null) {
                this.polynomial.put(t.getDegree(), t);
            }
        }
    }

    private Term parseTerm(String term) {
       // return new Term(term);
        int[] coeffDegree = new int[2];

        if (term.contains("x")) {
            int index = term.indexOf("x");

            if (index == 0 || term.charAt(index - 1) == '+') {
                coeffDegree[0] = 1;
            } else if (term.charAt(index - 1) == '-') {
                coeffDegree[0] = -1;
            } else {
                coeffDegree[0] = Integer.parseInt(term.substring(0, index));
            }

            if (term.length() == index + 1) {
                coeffDegree[1] = 1;
            } else {
                coeffDegree[1] = Integer.parseInt(term.substring(index + 2));
            }
        } else {
            coeffDegree[0] = Integer.parseInt(term);
            coeffDegree[1] = 0;
        }

        int numberOne=coeffDegree[0];
        int numberTwo=coeffDegree[1];

        return new Term(numberOne, numberTwo);
    }

    public TreeMap<Integer, Term> getPolynomial() {
        return polynomial;
    }

    @Override
    public String toString() {
        if (polynomial.isEmpty()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Map.Entry<Integer, Term> entry : polynomial.entrySet()) {
            int degree = entry.getKey();
            int coeff = entry.getValue().getCoeff();

            if (coeff == 0) {
                continue;
            }

            if (!first) {
                sb.append(coeff > 0 ? "+" : "-");
            } else if (coeff < 0) {
                sb.append("-");
            }

            first = false;
            coeff = Math.abs(coeff);

            if (degree == 0) {
                sb.append(coeff);
            } else if (degree == 1) {
                sb.append(coeff == 1 ? "x" : coeff + "x");
            } else {
                sb.append(coeff == 1 ? "x^" + degree : coeff + "x^" + degree);
            }
        }

        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

    public Poly add(Poly p) {
        TreeMap<Integer, Term> resultPoly = new TreeMap<>();
        for (Integer degree : this.getPolynomial().keySet()) {
            resultPoly.put(degree, this.getPolynomial().get(degree));
        }

        for (Integer degree : p.getPolynomial().keySet()) {
            if (resultPoly.containsKey(degree)) {
                Term newTerm = new Term(resultPoly.get(degree).getCoeff() + p.getPolynomial().get(degree).getCoeff(), degree);
                resultPoly.put(degree, newTerm);
            } else {
                resultPoly.put(degree, p.getPolynomial().get(degree));
            }
        }

        return new Poly(resultPoly);
    }

    public Poly subtract(Poly p) {
        TreeMap<Integer, Term> resultPoly = new TreeMap<>();

        for (Integer degree : polynomial.keySet()) {
            resultPoly.put(degree, polynomial.get(degree));
        }

        for (Integer degree : p.getPolynomial().keySet()) {
            if (resultPoly.containsKey(degree)) {
                Term newTerm = new Term(resultPoly.get(degree).getCoeff() - p.getPolynomial().get(degree).getCoeff(), degree);
                resultPoly.put(degree, newTerm);
            } else {
                Term newTerm = new Term(-p.getPolynomial().get(degree).getCoeff(), degree);
                resultPoly.put(degree, newTerm);
            }
        }

        return new Poly(resultPoly);
    }

    public Poly multiply(Poly other) {
        Poly result = new Poly();

        TreeMap<Integer, Term> otherPoly = other.getPolynomial();

        for (int deg1 : polynomial.keySet()) {
            for (int deg2 : otherPoly.keySet()) {
                int newDegree = deg1 + deg2;

                Term newTerm = polynomial.get(deg1).multiply(otherPoly.get(deg2));
                Term existingTerm = result.polynomial.get(newDegree);

                if (existingTerm == null) {
                    result.polynomial.put(newDegree, newTerm);
                } else {
                    existingTerm.setCoeff(existingTerm.getCoeff() + newTerm.getCoeff());
                }
            }
        }

        return result;
    }

    public Poly differentiate() {
        Poly result = new Poly();

        for (int deg : polynomial.keySet()) {
            Term term = polynomial.get(deg).diff();

            if (term.getCoeff() != 0) {
                result.polynomial.put(term.getDegree(), term);
            }
        }
        return result;
    }

    public int degree() {
        int highestDegree = 0;

        for (int degree : polynomial.keySet()) {
            if (degree > highestDegree) {
                highestDegree = degree;
            }
        }

        return highestDegree;
    }

    public double leadingCoeff() {
        return polynomial.get(degree()).getCoeff();
    }

}

