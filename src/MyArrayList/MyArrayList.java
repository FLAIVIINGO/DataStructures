package MyArrayList;

import MyListInteface.MyList;

import java.util.Iterator;

/**
 * This class is an implementation of a dynamic array 
 * using generic types.
 *
 * @param <T> generic type
 * @author Andrew Babilonia
 */

public class MyArrayList<T> implements MyList<T>, Iterable<T> {
    /**
     * Array of generic types
     */

    private T[] storage;
  
    /**
     * Size variable for array list
     * User level information
     */

    private int size;

    /**
     * Actual size of array list, unknown to user
     */

    private int capacity;

    /**
     * List constructor
     * Initializes to a specified capacity from user
     * @param initialCapacity initial capacity of the list
     * @throws IllegalArgumentException if capacity is negative
     */

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException();
        storage = (T[]) new Object[initialCapacity];
        this.size = 0;
        this.capacity = initialCapacity;
    }

    /**
     * Default arraylist constructor
     * Initializes this arraylist to a default
     * value of 10
     */

    public MyArrayList() {
        this(10);
    }

    /**
     * Returns the capacity of the list
     * @return capacity
     */

    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Returns the number of elements in this list
     * @return size
     */

    public int size() {
        return this.size;
    }

    /**
     * Returns true if this arraylist
     * contains no elements
     * @return boolean value of T/F
     */

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the index of the first occurrence of
     * the specified element in this list or -1
     * if this list does not contain the element
     * @param o the object being queried
     * @return i the index of the queried object
     */

    public int indexOf(Object o) {
        if(o == null) {
            for(int i = 0; i < size(); i++) {
                if(this.storage[i] == null)
                    return i;
            }
        }
        else {
            for (int i = 0; i < size(); i++) {
                if (this.storage[i] != null && this.storage[i].equals(o))
                    return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the
     * specified element in this list, or 01 if this
     * list does not contain the element
     * @param o the object in question
     * @return lastIdx the last occurrence of the element
     */

    public int lastIndexOf(Object o) {
        int lastIdx = -1;
        for (int i = 0; i < size(); i++) {
            if (this.storage[i].equals(o))
                lastIdx = i;
        }
        return lastIdx;
    }

    /**
     * Returns true if this list contains the
     * specified element
     * @param o the object being queried
     * @return T/F boolean value
     */

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Returns an iterator over the elements in this
     * list in proper sequence
     * @param T generic type
     * @return iterator
     */

    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            int index = 0;

            /**
             * Returns true if the iteration has more
             * elements
             * @return T/F boolean value
             */

            public boolean hasNext() {
                return index < size();
            }

            /**
             * Returns the next element in the iteration
             * @return element
             */

            public T next() {
                return storage[index];
            }
        };
        return it;
    }

    /**
     * Returns an array containing all of the elements in
     * this list in proper sequence; the runtime type of the 
     * returned array is that of the specified array
     * @return type defined array
     */

    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        T[] newArr = (T[]) new Object[size()];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = storage[i];
        }
        return newArr;
    }

    /**
     * Appends the specified element to the end
     * of this list
     * @param t the element
     * @return boolean value of true
     */

    public boolean add(T t) {
        ensureCapacity(size() + 1);
        this.storage[size++] = t;
        return true;
    }

    /**
     * Removes the first occurrence of the specified
     * element from this list, if it is present
     * @param o the object to be removed
     * @return boolean T/F if the item was removed
     * in the list
     */

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1)
            return false;
        removeAt(index);
        return true;
    }

    /**
     * Removes the element at the specified position in
     * this list
     * @param index
     * @return the element that was previously
     * in the specified index of this list
     */

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

    /**
     * Removes all of the elements from this list
     */

    @SuppressWarnings("unchecked")
    public void clear() {
        T[] newStorage = (T[]) new Object[capacity];
        size = 0;
        this.storage = newStorage;
    }

    /**
     * Inserts the specified element at the specified
     * position in this list
     * @param index
     * @param element
     */

    public void add(int index, T element) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        ensureCapacity(size() + 1);
        for (int i = size() - 1; i >= index; i--) {
            this.storage[i + 1] = this.storage[i];
        }
        this.storage[index] = element;
        this.size++;
    }

    /**
     * Returns the element at the specified position
     * in this list
     * @param index
     * @return the element at the specified position
     */

    public T get(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        return this.storage[index];
    }

    /**
     * Replaces the element at the specified position
     * in this list with the specified element
     * @param index
     * @param element
     * @return the element that was previously held
     * at the specified position
     */

    public T set(int index, T element) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        T data = this.storage[index];
        this.storage[index] = element;
        return data;
    }

    /**
     * Trims the capacity of this ArrayList instance
     * to be the list's current size
     */

    @SuppressWarnings("unchecked")
    public void trimToSize() {
        T[] newStorage = (T[]) new Object[size()];
        for (int i = 0; i < size(); i++) {
            newStorage[i] = storage[i];
        }
        this.capacity = size();
        this.storage = newStorage;
    }

    /**
     * Increases the capacity of this ArrayList instance,
     * if necessary, to ensure that it can hold at least
     * the number of elements specified by the minimum
     * capacity argument
     * @param minCapacity
     */

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

    /**
     * Returns a string representation of the object
     * @return string representation
     */

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
