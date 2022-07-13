package LinkedList;

public class App {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.insert(3);
        list.insert(5);
        list.insert(7);
        list.insert(1);

        System.out.println(list.size());
        list.traverse();


//        list.remove(300);
//        list.traverse();
//        System.out.println();
//        System.out.println("**********************************************************************************");

//        list.insert(100);
//        list.traverse();
        System.out.println();
        System.out.println("**********************************************************************************");
        list.reverse();
    }
}
