import java.util.Iterator;

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

    }

    public boolean contains(Object o) {
        return false;
    }

    public T get(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public int lastIndexOf(Object o) {
        return 0;
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
        s_list.add(2, 10);
        System.out.println(s_list.size());
        System.out.println(s_list.toString());
    }
}
