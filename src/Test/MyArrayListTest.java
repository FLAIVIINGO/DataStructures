import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import MyArrayList.MyArrayList;

public class MyArrayListTest {
    @Test(timeout=2000)
    public void testDefaultCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>();

        // scenario -- test default capacity, should be 10
        int capacity = list.getCapacity();
        assertEquals("After declaration, capacity should be 10.", 10,
            capacity);
    }

    @Test(timeout=2000)
    public void testDefaultSize() {
        MyArrayList<Integer> list = new MyArrayList<>();

        // scenario -- test default size, should be 0
        int size = list.size();
        assertEquals("After declaration, size should be 0.", 0,
            size);
    }

    @Test(expected = IllegalArgumentException.class) 
        public void testIllegalArgumentException() {
          // scenario -- negative capacity should throw
          // IllegalArgumentException
          MyArrayList<Integer> list = new MyArrayList<>(-1);

        }

    @Test(timeout=2000)
    public void testUserSetCapacity() {
        // scenario -- check initial capacity set by user
        MyArrayList<Integer> list = new MyArrayList<>(300);
        int capacity = list.getCapacity();
        assertEquals("After declaration, capacity should be 300.", 300, 
            capacity);
    }

    @Test(timeout=2000)
    public void testIsEmpty() {
        // scenario -- test isEmpty
        MyArrayList<Integer> list = new MyArrayList<>();
        boolean empty = list.isEmpty();
        assertEquals("List should be empty", true, empty);
    }

    @Test(timeout=2000)
    public void testAppend() {
        // scenario -- test append functionality
        MyArrayList<Integer> list = new MyArrayList<>();
        int[] elements = {1, 2, 3, 4, 5};
        for(int i = 0; i < elements.length; i++)
          list.add(elements[i]);
        for(int i = 0; i < elements.length; i++)
          assertEquals(list.get(i).intValue(), elements[i]);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addIndexOutOfBounds() {
        // scenario -- index out of bounds add
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(-1, 3);
    }

    @Test(timeout=2000)
    public void testAddAtIndex() {
        // scenario -- test adding element at a specific index
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2, 5);
        int[] elements = {1,2,5,3,4};
        for(int i = 0; i < elements.length; i++)
          assertEquals(list.get(i).intValue(), elements[i]);
    }

    @Test(timeout=2000)
    public void testAddAndRemove() {
        // scenario -- test adding and removing items
        // from the array list

        MyArrayList<Integer> list = new MyArrayList<>(0);
        for(int i = 0; i < 25; i++)
          list.add(20);
        for(int i = 0; i < 25; i++)
          list.remove(20);
        assertTrue(list.isEmpty());
        for(int i = 0; i < 25; i++)
          list.add(20);
        for(int i = 0; i < 25; i++)
          list.removeAt(0);
        assertTrue(list.isEmpty());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemovingFromEmptyList() {
        // scenario -- remove from empty list
        MyArrayList<Integer> list = new MyArrayList<>();
        list.removeAt(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexException() {
        // scenario -- remove element from out of bounds
        // index
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeAt(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFromNegativeIndex() {
        // scenario -- pass negative index to removeAt
        MyArrayList<Integer> list = new MyArrayList<>();
        for(int i = 0; i < 25; i++)
          list.add(25);
        list.removeAt(25);
    }

    @Test(timeout=2000)
    public void testRemove() {
        // scenario -- test remove functionality
        MyArrayList<Character> list = new MyArrayList<>();
        Character[] args = {'b', 'c', 'd', null, 'r'};
        for(int i = 0; i < args.length; i++) {
            list.add(args[i]);
        }
        boolean remove = list.remove('b');
        assertTrue(remove);

        remove = list.remove('b');
        assertFalse(remove);

        remove = list.remove(null);
        assertTrue(remove);

        remove = list.remove(null);
        assertFalse(remove);
    }

    // run the tests
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("MyArrayListTest");
    }
}
