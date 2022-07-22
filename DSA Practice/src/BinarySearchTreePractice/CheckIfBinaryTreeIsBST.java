package BinarySearchTreePractice;

public class CheckIfBinaryTreeIsBST {

    private Node root;

    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val  = val;
        }
    }

    private static boolean isBST(Node root, long min, long max) {

        if(root == null){
            return true;
        }

        if(root.val >= max || root.val <= min) return false;

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    static void inOrderTraversal(Node node){
        if(node.left != null){
            inOrderTraversal(node.left);
        }

        System.out.print(node.val + " ");

        if(node.right != null){
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {

        CheckIfBinaryTreeIsBST tree = new CheckIfBinaryTreeIsBST();

        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        inOrderTraversal(tree.root);
        System.out.println();
        System.out.println(isBST(tree.root, Long.MIN_VALUE, Long.MAX_VALUE));
    /*
             4
           /  \
          2    5
        /   \
      1      3

    */

    }

}
