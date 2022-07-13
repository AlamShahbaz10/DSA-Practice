package LeftAndRightViewOfBinaryTree;

public class TopView {

    private static class Node {

        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new TopView.Node(1);
        root.left = new TopView.Node(2);
        root.left.left = new TopView.Node(4);
        root.left.right = new TopView.Node(5);
        root.left.right.left = new TopView.Node(6);
        root.right = new TopView.Node(3);
        root.right.right = new TopView.Node(7);
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
