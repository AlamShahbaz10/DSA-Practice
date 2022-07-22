package Practice.LL;

public class ReverseLLInMiddle {

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private static Node head;

    static void reverseLLInMiddle(int m, int n) {

        Node curr = head;
        Node mPrev = null;
        Node startNode = null;
        Node endNode = null;
        Node nNext = null;

        int count = 0;

        while(count < m) {
            mPrev = curr;
            curr = curr.next;
            count++;
        }

        startNode = curr;
        while(count < n) {

            curr = curr.next;
            count++;
        }
        endNode = curr;
        nNext = curr.next;

        curr.next = null;

        Node reversedPart = reverseUsingRecursion(startNode);
        Node temp = reversedPart;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = nNext;
        mPrev.next = reversedPart;

    }

    static Node reverse(Node node) {
        Node prev = null;
        Node curr = node;
        Node temp = null;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        node = prev;
        return node;
    }

    static Node reverseUsingRecursion(Node head) {

        if(head == null || head.next == null) {
            return head;
        }
        Node node = reverseUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }



    private static void display(Node head) {

        Node curr = head;
        while(curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ReverseLLInMiddle list = new ReverseLLInMiddle();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);

        display(list.head);
        reverseLLInMiddle(2,5); // 1 -> 2 -> 6 -> 5 -> 4 -> 3 -> 7 -> 8 -> NULL
        display(list.head);

    }


}
