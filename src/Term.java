import java.util.Objects;

/***
 * Код определяет класс Term для работы с многочленами, который имеет
 * два свойства: coeff - коэффициент при степени x,
 * и degree - степень x.
 */
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

    /**
     * метод, возвращающий новый объект Term, у которого коэффициент равен произведению коэффициентов исходных
     * объектов, а степень равна сумме степеней исходных объектов;
     */
    public Term multiply(Term other) {
        double newCoeff = this.coeff * other.coeff;
        int newDegree = this.degree + other.degree;
        return new Term(newCoeff, newDegree);
    }

    public Term(int coeff, int degree) {
        this.coeff = coeff;
        this.degree = degree;
    }

    /**
     * метод, возвращающий значение коэффициента;
     */
    public int getCoeff() {
        return coeff;
    }

    /**
     * метод, возвращающий значение степени;

     */
    public int getDegree() {
        return degree;
    }

    /**
     * метод, устанавливающий значение коэффициента;
     */
    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

    /**
     * метод, устанавливающий значение степени;
     */
    public void setDegree(int degree) {
        this.degree = degree;
    }

    /**
     * метод, возвращающий новый объект Term, который представляет собой производную исходного объекта;
     */
    public Term diff() {
        return new Term(coeff * degree, degree - 1);
    }

    /**
     * метод, возвращающий результат вычисления значения многочлена в точке x
     */
    public double calc(double x) {
        return coeff * Math.pow(x, degree);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term = (Term) o;
        return coeff == term.coeff && degree == term.degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coeff, degree);
    }
}
