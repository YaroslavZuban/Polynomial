import java.util.Objects;
import java.util.TreeMap;

public abstract class BasePolynomial<T> {
    protected TreeMap<Integer, Term> polynomial;
    public abstract T add(T p);
    public abstract T subtract(T p);
    public abstract T multiply(T other);
    public abstract T differentiate();
    public abstract void clear();
    public abstract int degree();
    public abstract int coeff(int n);
    public abstract T minus();
    public abstract Term getTerm(int i);
}
