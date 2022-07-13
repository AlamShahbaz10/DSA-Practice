package LinkedList;

public class LinkedList<T extends Comparable<T>> implements List<T>{

    private Node<T> head;
    private int count;


    @Override
    public void insert(T data) {
        if(head == null){
            head = new Node<T>(data);
        }
        else{
            //insertAtBeginning(data);
             insertAtEnd(data, head);
        }
        count++;
    }

    //O(1)
    private void insertAtBeginning(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.setNextNode(head);
        head = newNode;
    }

    //O(N)
    //start with the head and travers till end
    private void insertAtEnd(T data, Node<T> node) {

        if(node.getNextNode() != null){
            insertAtEnd(data, node.getNextNode());
        }
        else{
            Node<T> newNode = new Node<T>(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void remove(T data) {

        if(head == null){
            return;
        }

        if(data.compareTo(head.getData())==0){
            head = head.getNextNode();
        }
        else{
            remove(data, head, head.getNextNode());
        }
    }

    private void remove(T data, Node<T> previousNode, Node<T> currentNode) {
        while(currentNode != null){
            if(data.compareTo(currentNode.getData())==0){
                count--;
                previousNode.setNextNode(currentNode.getNextNode());
                currentNode = null;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
    }


    @Override
    public void traverse() {
        if(head == null) return;

        Node<T> currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode);
            currentNode = currentNode.getNextNode();
        }
    }

    public void reverse(){

        if(head == null){
            return;
        }

        Node<T> current = head;
        Node<T> previousNode = null;
        Node<T> nextNode = null;

        //3->5->7->1->null
        while(current != null) {
            nextNode = current.getNextNode(); //5 --- 7 --- 1 --- null
            current.setNextNode(previousNode); //3->null --- 5->3->null --- 1->7->5->3->null
            previousNode = current;//3 --- 5 --- 7 --- 1
            current = nextNode; //5 --- 7 --- 1 --- null
        }

        head = previousNode;
        traverse();
    }

    @Override
    public int size() {
        return count;
    }
}
