package BinarySearchTreePractice;

import java.util.*;

public class BST {
    private class Node{
        private int val;
        private Node leftChild;
        private Node rightChild;
        private Node parentNode;

        public Node(int val, Node parentNode) {
            this.val = val;
            this.parentNode = parentNode;
        }
    }

    private Node root;

    public void insert(int val){
        if(root == null){
            root = new Node(val, null);
        }
        else{
            insert(val, root);
        }
    }

    private void insert(int val, Node node) {
        //right child
        if(val > node.val){
            if(node.rightChild != null) {
                insert(val, node.rightChild);
            }
            else {
                node.rightChild = new Node(val, node);
            }
        }
        //left child
        else{
            if(node.leftChild != null){
                insert(val, node.leftChild);
            }
            else{
                node.leftChild = new Node(val, node);
            }
        }
    }

    public void traversal(){
        if (root == null) return;

        System.out.println("INORDER Traversal");
        inorderTraversal(root);
        System.out.println();
        System.out.println("********************************");

        System.out.println("PREORDER Traversal");
        preorderTraversal(root);
        System.out.println();
        System.out.println("********************************");

        System.out.println("POSTORDER Traversal");
        postorderTraversal(root);
        System.out.println();
        System.out.println("********************************");
    }

    //left right root
    private void postorderTraversal(Node node) {

        if (node == null) return;

        if(node.leftChild != null){
            postorderTraversal(node.leftChild);
        }

        if(node.rightChild != null){
            postorderTraversal(node.rightChild);
        }

        System.out.print(node.val + " -> ");


    }

    //Root left right
    private void preorderTraversal(Node node) {

        if (node == null) return;

        System.out.print(node.val + " -> ");

        if(node.leftChild != null){
            preorderTraversal(node.leftChild);
        }

        if(node.rightChild != null){
            preorderTraversal(node.rightChild);
        }
    }

    //In order traversal (SORTED order) -> left, root, right
    private void inorderTraversal(Node node) {

        if (node == null) return;

        if(node.leftChild != null){
            inorderTraversal(node.leftChild);
        }

        System.out.print(node.val + " -> ");

        if(node.rightChild != null){
            inorderTraversal(node.rightChild);
        }
    }

    public void leftView(Node node){
        if (node == null) return;

        if(node != null){
            leftView(node.leftChild);
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public void rightView(Node node){
        if (node == null) return;

        if(node != null){
            System.out.print(node.val + " ");
            rightView(node.rightChild);
        }
        System.out.println();
    }

    public void topView(Node node){

        System.out.println("TOP VIEW: ");
        if (node == null) return;

        if(node != null){
            System.out.println(node.val);
            leftView(node.leftChild);
        }
        if(node.rightChild != null){
            System.out.println(node.rightChild.val);
            rightView(node.rightChild);
        }
    }

    public void topViewOfBinaryTree(Node node){

        if(node == null){
            return;
        }

        class MyQueue {
            int hd;
            Node node;

            public MyQueue(int hd, Node node) {
                this.hd = hd;
                this.node = node;
            }
        }

        Map<Integer, Node> treeMap = new TreeMap<>();
        Queue<MyQueue> queue = new LinkedList<>();

        queue.add(new MyQueue(0, node));

        while(!queue.isEmpty()){
            MyQueue temp = queue.poll();
            if(!treeMap.containsKey(temp.hd)){
                treeMap.put(temp.hd, temp.node);
            }

            if(temp.node.leftChild != null){
                queue.add(new MyQueue(temp.hd - 1, temp.node.leftChild));
            }

            if(temp.node.rightChild != null){
                queue.add(new MyQueue(temp.hd + 1, temp.node.rightChild));
            }
        }

        System.out.println("Top view of Binary tree: ");
        for (Map.Entry<Integer, Node> entry: treeMap.entrySet()) {
            System.out.print(entry.getValue().val + " ");
        }
        System.out.println();
    }

    public void bottomViewOfBinaryTree(Node node){

        if(node == null){
            return;
        }

        class MyQueue {
            int hd;
            Node node;

            public MyQueue(int hd, Node node) {
                this.hd = hd;
                this.node = node;
            }
        }

        Map<Integer, Node> treeMap = new TreeMap<>();
        Queue<MyQueue> queue = new LinkedList<>();

        queue.add(new MyQueue(0, node));

        while(!queue.isEmpty()){

            MyQueue temp = queue.poll();
            treeMap.put(temp.hd, temp.node);

            if(temp.node.leftChild != null){
                queue.add(new MyQueue(temp.hd - 1, temp.node.leftChild));
            }

            if(temp.node.rightChild != null){
                queue.add(new MyQueue(temp.hd + 1, temp.node.rightChild));
            }
        }

        System.out.println("Bottom view of Binary tree: ");
        for (Map.Entry<Integer, Node> entry: treeMap.entrySet()) {
            System.out.print(entry.getValue().val + " ");
        }

        System.out.println();
    }

    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(Node root, int val) {
        if(root == null) {
            return false;
        }

        if(val > root.val){
            return contains(root.rightChild, val);
        }
        if(val < root.val) {
            return contains(root.leftChild, val);
        }

        return true;
    }


    public static void main(String[] args) {

        BST bst = new BST();
        bst.insert(5);
        bst.insert(2);
        bst.insert(3);
        bst.insert(1);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);

        System.out.println("Contains value: " + bst.contains(6));

        bst.traversal();

        System.out.println("LEFT VIEW: ");
        bst.leftView(bst.root);
        System.out.println("****************************");


        System.out.println("RIGHT VIEW: ");
        bst.rightView(bst.root);
        System.out.println("****************************");

//        bst.topView(bst.root); //Incorrect

        bst.topViewOfBinaryTree(bst.root);
        System.out.println("****************************");

        bst.bottomViewOfBinaryTree(bst.root);

    }
}

/*

                    5
            2               7
        1       3        6      8


 */
