public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> numbers = new BinaryTree<>();
        BinaryTree<String> names = new BinaryTree<>();

        numbers.add(5);
        numbers.add(3);
        numbers.add(10);
        numbers.add(2);

        //numbers.remove(10);

        names.add("Connor");
        names.add("Bryan");
        names.add("Adam");

        System.out.println(names);

        System.out.println(numbers);
    }
}
