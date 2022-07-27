package Practice.Amazon;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] inputArr = {6, 8, 3, 10};
        solution1(inputArr);
        System.out.println();
        solution2(inputArr);
    }

    private static void solution1(int[] inputArr) {
        int[] outputArr = new int[inputArr.length];

        for (int i = 0; i < inputArr.length - 1; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                if(inputArr[j] > inputArr[i]) {
                    outputArr[i] = inputArr[j];
                    break;
                }
            }
        }
        outputArr[inputArr.length - 1] = -1;

        for(int i: outputArr){
            System.out.print(i + " ");
        }
    }

    private static void solution2(int[] inputArr) {
        int[] outputArr = new int[inputArr.length];

        outputArr[inputArr.length - 1] = -1;

        Stack<Integer> stack = new Stack();
        for (int i = inputArr.length - 1; i >= 0 ; i--) {
            stack.push(inputArr[i]);
        }

        for (int i = 0; i < inputArr.length; i++) {
            while(!stack.isEmpty()){
                if(inputArr[i] >= stack.peek()) {
                    stack.pop();
                } else {
                    outputArr[i] = stack.peek();
                    break;
                }
            }

        }

        for(int i: outputArr){
            System.out.print(i + " ");
        }
    }
}
