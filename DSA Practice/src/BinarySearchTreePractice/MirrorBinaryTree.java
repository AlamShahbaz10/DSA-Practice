package BinarySearchTreePractice;

public class MirrorBinaryTree {

    private Node root;

    static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val  = val;
        }
    }

    public static void main(String[] args) {

        MirrorBinaryTree tree = new MirrorBinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        inOrderTraversal(tree.root);
        System.out.println();
        mirror(tree.root);
        inOrderTraversal(tree.root);

    }
    /*
             1
           /  \
          2    3
        /   \
      4      5

      Mirror:
             1
           /  \
          3    2
             /   \
            5     4

     */

    static Node mirror(Node node){
        if(node == null){
            return node;
        }

        Node left = mirror(node.left);
        Node right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
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
}
