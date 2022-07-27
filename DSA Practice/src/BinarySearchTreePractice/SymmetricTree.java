package BinarySearchTreePractice;

public class SymmetricTree {

    private Node root;

//    static class Node{
//        private int val;
//        private Node left;
//        private Node right;
//
//        public Node(int val){
//            this.val  = val;
//        }
//    }

    public static void main(String[] args) {

        SymmetricTree tree = new SymmetricTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);

        System.out.println(tree.root == null || checkIsSymmetry(tree.root.left, tree.root.right));

    }

    private static boolean checkIsSymmetry(Node left, Node right) {

        if((left == null) || (right == null)) return (left == right);
        return (left.val == right.val) && checkIsSymmetry(left.left, right.right) && checkIsSymmetry(left.right, right.left);
    }

}

 class Node{
    int val;
    Node left;
    Node right;

    public Node(int val){
        this.val  = val;
    }
}


