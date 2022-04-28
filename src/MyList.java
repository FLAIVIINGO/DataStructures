import java.util.Collection;

public interface MyList<T> extends Collection<T>, Iterable<T> {
    boolean add(T t);

    void add(int index, T element);
}
