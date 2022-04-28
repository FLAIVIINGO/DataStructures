public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        MyArrayList<Integer> list = new MyArrayList<>(4);
        System.out.println(list.getCapacity());
        System.out.println(list.size());
        list.add(5);
        list.add(10);
        list.add(30);
        list.add(1);
        list.add(3);
        System.out.println(list.size());
        System.out.println(list.getCapacity());
        System.out.println(list.toString());
        list.remove(30);
        System.out.println(list.toString());
    }
}
