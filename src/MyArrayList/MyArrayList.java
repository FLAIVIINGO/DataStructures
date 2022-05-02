package MyArrayList;

import MyListInteface.MyList;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private T[] storage;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException();
        storage = (T[]) new Object[initialCapacity];
        this.size = 0;
        this.capacity = initialCapacity;
    }

    public MyArrayList() {
        this(10);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++) {
            if (this.storage[i].equals(o))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int lastIdx = -1;
        for (int i = 0; i < size(); i++) {
            if (this.storage[i].equals(o))
                lastIdx = i;
        }
        return lastIdx;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < size();
            }

            public T next() {
                return storage[index];
            }
        };
        return it;
    }

    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        T[] newArr = (T[]) new Object[size()];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = storage[i];
        }
        return newArr;
    }

    public boolean add(T t) {
        ensureCapacity(size() + 1);
        this.storage[size++] = t;
        return true;
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1)
            return false;
        removeAt(index);
        return true;
    }

    @SuppressWarnings("unchecked")
    public T removeAt(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        T data = storage[index];
        T[] newStorage = (T[]) new Object[this.capacity];
        for (int i = 0, j = 0; i < size(); i++, j++) {
            if (i == index)
                j--;
            else
                newStorage[j] = this.storage[i];
        }
        this.storage = newStorage;
        this.size--;
        return data;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        T[] newStorage = (T[]) new Object[capacity];
        size = 0;
        this.storage = newStorage;
    }

    public void add(int index, T element) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        ensureCapacity(size() + 1);
        for (int i = size() - 1; i >= index; i--) {
            this.storage[i + 1] = this.storage[i];
        }
        this.storage[index] = element;
        this.size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        return this.storage[index];
    }

    public T set(int index, T element) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        T data = this.storage[index];
        this.storage[index] = element;
        return data;
    }

    @SuppressWarnings("unchecked")
    public void trimToSize() {
        T[] newStorage = (T[]) new Object[size()];
        for (int i = 0; i < size(); i++) {
            newStorage[i] = storage[i];
        }
        this.capacity = size();
        this.storage = newStorage;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > this.capacity) {
            if (this.capacity == 0)
                this.capacity = 1;
            this.capacity *= 2;
            T[] newStorage = (T[]) new Object[this.capacity];
            for (int i = 0; i < size(); i++) {
                newStorage[i] = storage[i];
            }
            this.storage = newStorage;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size() > 0) {
            for (int i = 0; i < size() - 1; i++) {
                sb.append(this.storage[i]).append(", ");
            }
            sb.append(this.storage[size() - 1]);
        }
        sb.append("]");
        return sb.toString();
    }
}