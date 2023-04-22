public class Term {
    private int coeff;
    private int degree;

    public Term() {
        this.coeff = 0;
        this.degree = 0;
    }

    public Term(double coeff, double degree) {
        this.coeff = (int) coeff;
        this.degree = (int) degree;
    }

    public Term multiply(Term other) {
        double newCoeff = this.coeff * other.coeff;
        int newDegree = this.degree + other.degree;
        return new Term(newCoeff, newDegree);
    }

    public Term(int coeff, int degree) {
        this.coeff = coeff;
        this.degree = degree;
    }

    public int getCoeff() {
        return coeff;
    }

    public int getDegree() {
        return degree;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        if (coeff == 0 || degree == 0) {
            return Integer.toString(coeff);
        }
        if (degree == 1) {
            if (Math.abs(coeff) == 1) {
                return "X";
            } else {
                return coeff + "X";
            }
        }else {
            if (coeff == 1) {
                return "X^" + degree;
            } else {
                return coeff + "X^" + degree;
            }
        }
    }

    public Term diff() {
        return new Term(coeff * degree, degree - 1);
    }

    public double calc(double x) {
        return coeff * Math.pow(x, degree);
    }
}
