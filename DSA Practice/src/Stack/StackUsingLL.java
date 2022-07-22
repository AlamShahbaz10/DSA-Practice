package Stack;

public class StackUsingLL {

    private static Node head;
    private static Node tail;

    private static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {

        push(10);
        push(20);
        push(30);
        System.out.println("Popped: " + pop());
        display();
        System.out.println("Peek value: " + peek());

        display();


    }

    private static void display() {
        if(head == null) return;
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static int peek() {
        if(head == null){
            System.out.println("Stack is empty!");
            return -1;
        }
        return tail.val;
    }

    private static int pop() {
        if(head == null){
            System.out.println("Stack is empty!");
            return -1;
        }

        Node curr = head;
        Node tailPrevious = null;
        while(curr.next != tail){

            curr = curr.next;
            tailPrevious = curr;
        };

        Node temp = tail;
        tail = tailPrevious;
        tail.next = null;
        return temp.val;
    }

    private static void push(int val) {
        Node temp = new Node(val);
        if(head == null){
            head = temp;
            tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;
    }
}
