package Stack;

public class Stack {

    private static final int DEFAULT_SIZE = 10;
    int[] myStack;
    int ptr = 0;

    Stack(int size){
        this.myStack = new int[size];
    }

    Stack(){
        this(DEFAULT_SIZE);
    }

    public void push(int n) throws StackException {
        if(isFull()){
            throw new StackException("Stack is full!");
        }

        myStack[ptr++] = n;
    }

    public Integer pop() throws StackException {
        if(isEmpty()){
            throw new StackException("Stack is empty!");
        }

        return myStack[--ptr];
    }

    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("Stack is empty!");
        }

        return myStack[ptr-1];
    }

    public boolean isFull(){
        return ptr == myStack.length;
    }

    public boolean isEmpty(){
        return ptr == 0;
    }

    public void display(){
        for (int i = 0; i < myStack.length; i++) {
            System.out.println(myStack[i]);
        }
    }

    public static void main(String[] args) throws StackException {

        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);


        System.out.println(stack.peek());

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        stack.display();

    }
}
