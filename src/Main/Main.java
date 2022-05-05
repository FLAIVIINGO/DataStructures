import MyArrayList.MyArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");

        MyArrayList<Character> list1 = new MyArrayList<>();
        list1.add('b');
        list1.add('c');
        list1.add('d');
        list1.add(null);

        System.out.println(list1.remove('b'));
        System.out.println(list1.remove('b'));
        System.out.println(list1.remove(null));
    }
}
