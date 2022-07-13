package CLL;

public class CLL {

    class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void insert(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
        }

        tail.next = newNode;
        newNode.next = head;
        tail = newNode;

        size++;
    }

    public void display(){
        Node temp = head;
        do{
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }while(temp != head);

        System.out.println("HEAD");
    }

//    public void delete(int index){
//        if(size == 0){
//            System.out.println("CLL is empty");
//            return;
//        }
//        if(index < size){
//            Node temp = head;
//            for(int i=0; i<=index; i++){
//                temp = temp.next;
//            }
//        }
//
//    }

    public void delete(){
        if(head == null) return;

        head = head.next;
        tail.next = head;

    }

    public static void main(String[] args) {

        CLL cll = new CLL();
        cll.insert(10);
        cll.insert(18);
        cll.insert(7);
        cll.insert(9);
        cll.display();

        cll.delete();
        cll.display();

    }
}
