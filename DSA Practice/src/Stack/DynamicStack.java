package Stack;

public class DynamicStack extends Stack{

    DynamicStack(){
        super();
    }

    DynamicStack(int size){
        super(size);
    }

    @Override
    public void push(int n) throws StackException {
        if(isFull()){
            int[] temp = new int[myStack.length * 2];
            for (int i = 0; i < myStack.length; i++) {
                temp[i] = myStack[i];
            }
            myStack = temp;
        }
        super.push(n);
    }

    public boolean isFull(){
        return ptr == myStack.length;
    }

    public boolean isEmpty(){
        return ptr == 0;
    }

    public static void main(String[] args) throws StackException {
        Stack stack = new DynamicStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.push(100);


        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
