package DoublyLL;

public class DLL {

    private class Node{

        private int val;
        private Node next;
        private Node previous;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size;

    public void insertAtStart(int val){
        if(head == null){
            head = new Node(val);
        }
        else{
            Node newNode = new Node(val);
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        size++;
    }

    public void insertAtEnd(int val){

        if(head == null){
            head = new Node(val);
        }
        else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            Node newNode = new Node(val);
            newNode.previous = temp;
            temp.next = newNode;
        }

        size++;
    }

    public void insertAtIndex(int val, int index){

        if(index > size) return;

        if(index == 0){
            insertAtStart(val);
            return;
        }

        if(index == size){
            insertAtEnd(val);
            return;
        }

        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        Node newNode = new Node(val);


        newNode.previous = temp.previous; // 99<-23
        temp.previous.next = newNode; //99->23

        temp.previous = newNode;
        newNode.next = temp;

        size++;
    }

    public void display(){
        Node temp = head;
        System.out.print("NULL <-> ");
        while(temp != null){
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");

    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertAtStart(1);
        dll.insertAtStart(2);
        dll.insertAtStart(3);
        dll.insertAtStart(4);
        dll.insertAtStart(5);
        dll.display();

        dll.insertAtStart(99);
        dll.display();

        dll.insertAtEnd(1111);
        dll.display();

        dll.insertAtIndex(23, 1);
        dll.display();
    }

}
