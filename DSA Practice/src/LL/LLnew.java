package LL;

public class LLnew {

    private Node head;
    private int size;

    public void insertAtEnd(int val){
        if(head == null){
            head = new Node(val);
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            Node newNode = new Node(val);
            temp.next = newNode;
        }

        size++;
    }

    public void insertAtStart(int val){

        if(head == null){
            head = new Node(val);
        }
        else{
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
        }

        size++;
    }

    public void insertAtIndex(int val, int index){

        if(index > size) return;

        Node temp = head;
        Node newNode = new Node(val);

        if(index == 0){
            insertAtStart(val);
            return;
        }
        if(index == size){
            insertAtEnd(val);
            return;
        }
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        size++;

    }

    public void insertUsingRecursion(int val, int index){
        head  = insertUsingRecursion(val, index, head);
    }

    private Node insertUsingRecursion(int val, int index, Node node){

        if(index == 0){
            Node newNode = new Node(val, node);
            size++;
            return newNode;
        }

        node.next = insertUsingRecursion(val, --index, node.next);

        return node;
    }

    public void deleteFirst(){
        head = head.next;
        size--;
    }

    public void deleteLast(){

        Node temp = head;
        Node previous = null;
        while(temp.next != null){
            previous = temp;
            temp = temp.next;
        }

        previous.next = null;

        size--;
    }

    public void deleteAtIndex(int index){

        if(index >= size) return;

        if(index == 0){
            deleteFirst();
            return;
        }

        if(index == size-1){
            deleteLast();
            return;
        }

        Node temp = head;
        Node previous = null;
        for(int i=0; i<index; i++){
            previous = temp;
            temp = temp.next;
        }

        previous.next = temp.next;

    }

    private void display() {
        Node temp = head;
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void removeDuplicates(){
        Node node = head;
        while(node.next != null){
            if(node.val == node.next.val){
                node.next = node.next.next;
                size--;
            }
            else{
                node = node.next;
            }
        }
    }

    public LLnew mergeTwoSortedList(LLnew ll1, LLnew ll2){
        LLnew ll3 = new LLnew();

        Node temp1 = ll1.head;
        Node temp2 = ll2.head;

        while(temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                ll3.insertAtEnd(temp1.val);
                temp1 = temp1.next;
            }
            else{
                ll3.insertAtEnd(temp2.val);
                temp2 = temp2.next;
            }
        }

        while(temp1 != null){
            ll3.insertAtEnd(temp1.val);
            temp1 = temp1.next;
        }

        while(temp2 != null){
            ll3.insertAtEnd(temp2.val);
            temp2 = temp2.next;
        }

        return ll3;
    }

    public boolean hasCycle(LLnew list){

        Node slow = list.head;
        Node fast = list.head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                System.out.println("Length of cycle: " + cycleLength(slow, fast));
                System.out.println("Index where cycle starts: " + indexOfCycle(slow));
                return true;
            }
        }

        return false;
    }

    private int indexOfCycle(Node slow) {
        int index = 0;

        Node first = head;
        Node second = slow;

        while(first != second){
            first = first.next;
            second = second.next;

            index++;
        }

        return index;
    }

    public int cycleLength(Node slow, Node fast){
        int length = 0;
        do{
            slow = slow.next;
            length++;
        }while(slow != fast);

        return length;
    }

    public boolean isHappyNumber(int n){

        int s = n;
        int f = n;

        do {
            s = calcSquare(s);
            f = calcSquare(calcSquare(f));
        }while(s != f);

        if(s == 1){
            return true;
        }

        return false;
    }

    private int calcSquare(int n){
        int ans = 0;
        while(n != 0){
            int rem = n % 10;
            ans += rem * rem;
            n = n/10;
        }
        return ans;
    }

    public Node middleNode(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private LLnew firstHalfOfLL(Node middleNode){

        LLnew firstHalfOfLL = new LLnew();

        Node temp = head;
        while(temp != middleNode){
            firstHalfOfLL.insertAtEnd(temp.val);
            temp = temp.next;
        }

        return firstHalfOfLL;
    }

    public LLnew reverseLL(){
        Node temp = head;
        LLnew newLL = new LLnew();

        while(temp != null){
            newLL.insertAtStart(temp.val);
            temp = temp.next;
        }

        return newLL;
    }

    public LLnew reverseLLFromMiddleNode(){

        Node middleNode = middleNode();
        LLnew firstHalfOfLL = firstHalfOfLL(middleNode);
        Node temp1 = firstHalfOfLL.head;
        while(temp1.next != null){
            temp1 = temp1.next;
        }

        Node temp2 = middleNode();


        LLnew newLL = new LLnew();

        while(temp2 != null){
            newLL.insertAtStart(temp2.val);
            temp2 = temp2.next;
        }


        Node head1 = firstHalfOfLL.head;
        Node head2 = newLL.head;
        LLnew orderedElements = orderElements(head1, head2);

        Node temp3 = newLL.head;
        while(temp3 != null){
            firstHalfOfLL.insertAtEnd(temp3.val);
            temp3 = temp3.next;
        }

        return firstHalfOfLL;
    }

    public LLnew orderElements(Node head1, Node head2){
        LLnew orderedElements = new LLnew();
        while(head1 != null && head2 != null){
            orderedElements.insertAtEnd(head1.val);
            orderedElements.insertAtEnd(head2.val);
            head1 = head1.next;
            head2 = head2.next;
        }

        return orderedElements;
    }

    public static void main(String[] args) {
        LLnew ll = new LLnew();

        ll.insertAtStart(3);
        ll.insertAtStart(20);
        ll.insertAtStart(20);
        ll.insertAtStart(1);

        ll.display();
        ll.removeDuplicates();
        ll.display();

        LLnew ll1 = new LLnew();
        ll1.insertAtEnd(1);
        ll1.insertAtEnd(2);
        ll1.insertAtEnd(4);

        LLnew ll2 = new LLnew();
        ll2.insertAtEnd(1);
        ll2.insertAtEnd(3);
        ll2.insertAtEnd(4);
        ll2.insertAtEnd(5);
        ll2.insertAtEnd(6);
        LLnew ll3 = ll.mergeTwoSortedList(ll1, ll2);
        ll3.display();

        LLnew list = new LLnew();
//        list.insertAtEnd(1);
//        list.insertAtEnd(2);
//        list.insertAtEnd(5);
//        list.insertAtEnd(8);
//        list.insertAtEnd(13);
//        list.head.next.next.next.next.next = list.head.next.next;

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.insertAtEnd(8);
//        list.head.next.next.next.next.next.next.next.next = list.head.next.next.next;
        System.out.println(list.hasCycle(list));


        System.out.println(list.isHappyNumber(2));
//        list.display();
//        System.out.println(list.middleNode().val);

        LLnew reversedList = list.reverseLL();
        reversedList.display();
        LLnew reversedListFromMiddleNode = list.reverseLLFromMiddleNode();
        reversedListFromMiddleNode.display();
        System.out.println(reversedListFromMiddleNode.size);


//        ll.insertAtStart(10);
//        ll.display();
//
//        ll.insertAtEnd(100);
//        ll.display();
//
//        ll.insertAtIndex(999, 1);
//        ll.display();
//
//        ll.insertUsingRecursion(1000, 2);
//        ll.display();



//        ll.deleteFirst();
//        ll.display();
//
//        ll.deleteLast();
//        ll.display();
//
//        ll.deleteAtIndex(5);
//        ll.display();

    }
}

 class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
