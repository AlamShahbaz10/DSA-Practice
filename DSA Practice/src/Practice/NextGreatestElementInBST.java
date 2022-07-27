package Practice;

public class NextGreatestElementInBST {

    private static Node root;

    private static class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        public Node(int val, Node parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    public static void insert (int val) {
        if(root == null) {
            root = new Node(val, null);
        } else {
            insert(val, root);
        }
    }

    private static void insert(int val, Node node) {
        if(val < node.val) {
            if(node.left != null){
                insert(val, node.left);
            } else {
                node.left = new Node(val, node);
            }
        } else {
            if(node.right != null){
                insert(val, node.right);
            } else {
                node.right = new Node(val, node);
            }
        }
    }

    public static Node nextGreatestElementInBST(Node node) {

        /* 1. Check if right node is present
               -> check all the way down to the left node and return that node
           2. If right node is NOT present, then check its parent node
           until its value is greater than the node value given
           OR simply check until (parent node != NULL && parent.val > node.val)
         */

        if(node.right != null) {
            return getLeftMostChildOfNextRight(node.right);
        }

        Node temp = node;
        while(temp.parent != null) {
            if(temp.parent.val < node.val) {
                temp = temp.parent;
            }else {
                return temp.parent;
            }
        }

        return temp;
    }

    private static Node getLeftMostChildOfNextRight(Node node) {
        if(node.left == null) {
            return node;
        } else {
            return getLeftMostChildOfNextRight(node.left);
        }
    }

    public static void inOrderTraversal(Node node) {

        if(node == null) return;

        if(node.left != null) {
            inOrderTraversal(node.left);
        }

        System.out.print(node.val + " ");

        if(node.right != null) {
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        NextGreatestElementInBST bst = new NextGreatestElementInBST();

        insert(20);
        insert(25);
        insert(9);
        insert(7);
        insert(12);
        insert(11);
        insert(14);

        inOrderTraversal(bst.root);
        System.out.println();

        System.out.println("Next greatest element is: " + nextGreatestElementInBST(root.left.right).val);
    }

    /*
                 20
               /   \
              9     25
            /  \
           7    12
               /  \
             11    14

     */
}
