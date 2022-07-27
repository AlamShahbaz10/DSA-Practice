package LeftAndRightViewOfBinaryTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

    private Node root;

    private static class Node {
        int hd;
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public void bottomView(Node node) {
        class MyQueue {
            int hd;
            Node node;
            public MyQueue (int hd, Node node) {
                this.hd = hd;
                this.node = node;
            }
        }
        Queue<MyQueue> queue = new LinkedList<>();
        TreeMap<Integer, Node> map = new TreeMap<>();

        queue.add(new MyQueue(0, node));

        while(!queue.isEmpty()) {
            MyQueue temp = queue.remove();

            map.put(temp.hd, temp.node);

            if(temp.node.left != null) {
                queue.add(new MyQueue(temp.hd - 1, temp.node.left));
            }

            if(temp.node.right != null) {
                queue.add(new MyQueue(temp.hd + 1, temp.node.right));
            }
        }

        for (Map.Entry<Integer, Node> entry: map.entrySet()) {
            System.out.print(entry.getValue().val + " ");
        }
        System.out.println();
    }

    public void bottomViewAltApproach(Node node) {

        Queue<Node> queue = new LinkedList<>();
        TreeMap<Integer, Node> map = new TreeMap<>();

        node.hd = 0;
        queue.add(node);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            map.put(temp.hd, temp);

            if(temp.left != null) {
                temp.left.hd = temp.hd - 1;
                queue.add(temp.left);
            }

            if(temp.right != null) {
                temp.right.hd = temp.hd + 1;
                queue.add(temp.right);
            }
        }

        for (Map.Entry<Integer, Node> entry: map.entrySet()) {
            System.out.print(entry.getValue().val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BottomView tree = new BottomView();
        tree.root = new Node(5);
        tree.root.left = new Node(2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(8);

        tree.bottomView(tree.root);
        tree.bottomViewAltApproach(tree.root);
    }
    /*
                     5
                   /  \
                 2     7
               /  \   / \
             1     3 6   8
     */
}
