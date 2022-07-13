package Queue;

import java.util.Stack;

public class Queue {

    private static final int DEFAULT_SIZE = 10;
    int[] myQueue;
    int ptr = 0;

    public Queue(int size){
        this.myQueue = new int[size];
    }

    public Queue(){
        this(DEFAULT_SIZE);
    }

    public boolean isFull(){
        return ptr == myQueue.length;
    }

    public boolean isEmpty(){
        return ptr == 0;
    }

    public void add(int n){
        if(isFull()){
            System.out.println("Queue is full!");
            return;
        }

        myQueue[ptr++] = n;
    }

    public int remove(){

        if(isEmpty()){
            System.out.println("Queue is empty!");
            return -1;
        }
        int removed = myQueue[0];

        for (int i = 1; i < ptr; i++) {
            myQueue[i-1] = myQueue[i];
        }
//        myQueue[--ptr] = 0;
        ptr--;
        return removed;
    }

    public void display(){
        for (int i = 0; i < ptr; i++) {
            System.out.print(myQueue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println("Removed element from Queue: " + queue.remove());

        queue.display();

        queue.add(60);
        queue.display();

        queue.add(70);
        queue.display();

//        while(!queue.isEmpty()){
//            System.out.println(queue.remove());
//        }
    }
}
