import java.util.Objects;
import java.util.TreeMap;

public abstract class BasePolynomial<T> {
    /**
     * хранящий многочлен в виде словаря, где ключом является степень многочлена,
     * а значением - объект класса Term, представляющий соответствующее слагаемое.
     */
    protected TreeMap<Integer, Term> polynomial;

    /**
     * метод, возвращающий результат сложения многочленов;
     */
    public abstract T add(T p);

    /**
     * метод, возвращающий результат вычитания многочленов;
     */
    public abstract T subtract(T p);

    /**
     *  метод, возвращающий результат умножения многочленов;
     */
    public abstract T multiply(T other);

    /**
     * метод, возвращающий производную многочлена;
     */
    public abstract T differentiate();

    /**
     *  метод, очищающий многочлен;
     */
    public abstract void clear();

    /**
     *  метод, возвращающий степень многочлена;
     */
    public abstract int degree();

    /**
     * метод, возвращающий коэффициент при заданной степени;
     */
    public abstract int coeff(int n);

    /**
     * метод, возвращающий результат умножения многочлена на -1;
     */
    public abstract T minus();

    /**
     *  метод, возвращающий объект Term, представляющий слагаемое с заданным индексом.
     */
    public abstract Term getTerm(int i);
}
