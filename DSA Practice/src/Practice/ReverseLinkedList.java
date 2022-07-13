package Practice;


public class ReverseLinkedList {

    static Node head = null;

    static Node reverse(Node node){

        Node previous = null;
        Node current = node;
        Node next = null;

        while(current!=null){
            next = current.nextNode;
            current.nextNode = previous;
            previous = current;
            current = next;
        }

        node = previous;
        return node;
    }

    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.nextNode;
        }
    }

    public static void main(String[] args) {

        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(85);
        list.head.nextNode = new Node(15);
        list.head.nextNode.nextNode = new Node(4);
        list.head.nextNode.nextNode.nextNode = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
//        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(list.reverse(head));

    }
}

class Node<T>{

    T data;
    Node<T> nextNode;

    public Node(T data) {
        this.data = data;
        this.nextNode = null;
    }
}
