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

    // run the tests
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("MyArrayListTest");
    }
}
