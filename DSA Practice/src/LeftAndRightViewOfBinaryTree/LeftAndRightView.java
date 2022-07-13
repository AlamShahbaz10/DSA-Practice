package LeftAndRightViewOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeftAndRightView{

    private static class Node {

        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    public void leftView(Node node, int level, List<Integer> result){

        if(node == null) return;

        if(level == result.size()){
            result.add(node.val);
        }

        leftView(node.left, level + 1, result);
        leftView(node.right, level + 1, result);
    }

    public void rightView(Node node, int level, List<Integer> result){

        if(node == null) return;

        if(level == result.size()){
            result.add(node.val);
        }

        rightView(node.right, level + 1, result);
        rightView(node.left, level + 1, result);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(7);

        List<Integer> result = new ArrayList<>();
//        new LeftAndRightView().leftView(root, 0, result);
        new LeftAndRightView().rightView(root, 0, result);
        System.out.println(result);
    }
}
/*
TOP VIEW => 4,2,1,3,7

                1
              /   \
            2      3
          /   \     \
        4       5    7
              /
            6

*/


