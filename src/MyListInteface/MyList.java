package MyListInteface;

import java.util.Iterator;

public interface MyList<T> extends Iterable<T> {
    boolean add(T t);

    void add(int index, T element);

    void clear();

    boolean contains(Object o);

    boolean equals(Object o);

    T get(int index);

    int indexOf(Object o);

    boolean isEmpty();

    Iterator<T> iterator();

    int lastIndexOf(Object o);

    T removeAt(int index);

    boolean remove(Object o);

    T set(int index, T element);

    int size();
}
