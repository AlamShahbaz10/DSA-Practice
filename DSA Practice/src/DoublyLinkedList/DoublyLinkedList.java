package DoublyLinkedList;

public class DoublyLinkedList<T extends Comparable<T>> implements List<T>{

    private Node<T> head;
    private Node<T> previousNode;
    private Node<T> nextNode;
    private int count;


    @Override
    public void insert(T data) {
        if(head == null){
            head = new Node<T>(data);
        }
        else{
            insertAtStart(data);
            insertAtEnd(data);
        }

        count++;
    }

    private void insertAtEnd(T data) {
    }

    private void insertAtStart(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.setNextNode(head);
        head = newNode;
    }

    @Override
    public void remove(T data) {

        count--;
    }

    @Override
    public void traverse() {

    }

    @Override
    public int size() {
        return count;
    }
}
