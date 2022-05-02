package LinkedList;

import MyListInteface.MyList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySingleLinkedList<T> implements MyList<T> {

    private class ListNode<T> {
        private T data;
        private ListNode<T> next;

        public ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private ListNode<T> head;
    private int size;

    public MySingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(T t) {
        if (size() == 0) {
            this.head = new ListNode<>(t, null);
        } else {
            ListNode<T> newNode = new ListNode<>(t, head);
            head = newNode;
        }
        this.size++;
    }

    public void addLast(T t) {
        if (size() == 0) addFirst(t);
        ListNode<T> temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode<>(t, null);
        size++;
    }

    public boolean add(T t) {
        addFirst(t);
        return true;
    }

    public void add(int index, T element) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(element);
        else if (index == size()) addLast(element);
        else {
            ListNode<T> prev = this.head;
            ListNode<T> temp = this.head.next;
            int i = 1;
            while (i < index) {
                i++;
                prev = prev.next;
                temp = temp.next;
            }
            prev.next = new ListNode<>(element, temp);
            size++;
        }
    }

    public void clear() {
        ListNode<T> trav = head;
        while (trav != null) {
            ListNode<T> next = trav.next;
            trav.data = null;
            trav = next;
        }
        this.head = trav = null;
        this.size = 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public T get(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        ListNode<T> temp = head;
        int i = 0;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        return temp.data;
    }

    public int indexOf(Object o) {
        ListNode<T> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == o) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            ListNode<T> trav = head;

            public boolean hasNext() {
                return trav.next != null;
            }

            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    public int lastIndexOf(Object o) {
        ListNode<T> temp = head;
        int index = -1;
        int i = 0;
        while (temp != null) {
            if (temp.data == o)
                index = i;
            i++;
            temp = temp.next;
        }
        return index;
    }

    public T element() {
        if (size() == 0) throw new NoSuchElementException();
        return this.head.data;
    }

    public T getFirst() {
        if (size() == 0) throw new NoSuchElementException();
        return this.head.data;
    }

    public T getLast() {
        if (size() == 0) throw new NoSuchElementException();
        ListNode<T> temp = head;
        while (temp.next != null)
            temp = temp.next;
        return temp.data;
    }

    public boolean offer(T t) {
        addLast(t);
        return true;
    }

    public boolean offerFirst(T t) {
        addFirst(t);
        return true;
    }

    public boolean offerLast(T t) {
        addLast(t);
        return true;
    }

    public T peek() {
        if (size() == 0) return null;
        return this.head.data;
    }

    public T peekFirst() {
        if (size() == 0) return null;
        return this.head.data;
    }

    public T peekLast() {
        if (size() == 0) return null;
        return getLast();
    }

    public T removeAt(int index) {
        return null;
    }

    public boolean remove(Object o) {
        return false;
    }

    public T set(int index, T element) {
        return null;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder().append("[");
        if (size() != 0) {
            ListNode<T> temp = this.head;
            while (temp.next != null) {
                sb.append(temp.data + ", ");
                temp = temp.next;
            }
            sb.append(temp.data);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MySingleLinkedList<Integer> s_list = new MySingleLinkedList<>();
        s_list.addFirst(1);
        s_list.addFirst(2);
        s_list.addLast(5);
        s_list.add(5);
        s_list.add(2, null);
        System.out.println(s_list.size());
        System.out.println(s_list.toString());
        System.out.println(s_list.get(0));
        System.out.println(s_list.indexOf(11));
        System.out.println(s_list.contains(null));
        System.out.println(s_list.lastIndexOf(5));
    }
}
