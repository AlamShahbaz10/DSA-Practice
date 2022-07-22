package BalancedBracket;

import java.util.Stack;

public class BalancedBracket {
    public static void main(String[] args) {
        System.out.println(areBracketsBalanced("{()}"));
    }

    private static boolean areBracketsBalanced(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '{' || ch == '(' || ch == '['){
                stack.push(ch);
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }

            char check = stack.pop();

            if(ch == '}' && (check == '(' || check == '[')){
                return false;
            }
            if(ch == ')' && (check == '{' || check == '[')){
                return false;
            }
            if(ch == ']' && (check == '(' || check == '{')){
                return false;
            }
        }

        return stack.isEmpty();
    }
}
