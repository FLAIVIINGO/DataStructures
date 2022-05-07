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

        remove = list.remove('r');
        assertTrue(remove);

        remove = list.remove('r');
        assertFalse(remove);

        remove = list.remove(null);
        assertTrue(remove);

        remove = list.remove(null);
        assertFalse(remove);
    }

    @Test(timeout=2000)
    public void testContains() {
        // scenario -- test contains functionality
        MyArrayList<Integer> list = new MyArrayList<>();
        int[] elements = {1,55,44,678,4};
        for(int i = 0; i < elements.length; i++) {
            list.add(elements[i]);
        }
        boolean contain = list.contains(1);
        assertTrue(contain);

        contain = list.contains(55);
        assertTrue(contain);

        contain = list.contains(4);
        assertTrue(contain);

        contain = list.contains(99);
        assertFalse(contain);
    }

    @Test(timeout=2000)
    public void testEnsureCapacity() {
        // scenario -- check that the capacity is doubling
        MyArrayList<Integer> list = new MyArrayList<>(4);
        int[] elements = {1,2,3,4};
        for(int i = 0; i < elements.length; i++)
          list.add(elements[i]);
        list.add(5);
        int capacity = list.getCapacity();
        assertEquals(8, capacity);
    }

    @Test(timeout=2000)
    public void testTrimToSize() {
        // scenario -- trim to size array
        MyArrayList<Integer> list = new MyArrayList<>(4);
        int[] elements = {1,2,3,4};
        for(int i = 0; i < elements.length; i++)
          list.add(elements[i]);
        list.add(5);
        list.trimToSize();
        int capacity = list.getCapacity();
        assertEquals(5, capacity);

    }

    @Test(timeout=2000)
    public void testGet1() {
      // scenario -- test a successful get
      MyArrayList<Integer> list = new MyArrayList<>();
      int[] elements = {1,2,3,4,5,6};
      for(int i = 0; i < elements.length; i++) {
          list.add(elements[i]);
      }
      int result = list.get(2);
      assertEquals(3, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet2() {
        // scenario -- get index out of bounds
      MyArrayList<Integer> list = new MyArrayList<>();
      int[] elements = {1,2,3,4,5,6};
      for(int i = 0; i < elements.length; i++) {
          list.add(elements[i]);
      }
      int result = list.get(6); 
    }

    @Test(timeout=2000)
    public void testSet1() {
        // scenario -- successful set method
        MyArrayList<String> list = new MyArrayList<>();
        String[] elements = {"a","b","d","r",null}; 
        for(int i = 0; i < elements.length; i++) {
            list.add(elements[i]);
        }
        String data = list.set(0, "z");
        assertEquals("z", list.get(0));
        assertEquals("a", data);
    }

    // run the tests
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("MyArrayListTest");
    }
}
