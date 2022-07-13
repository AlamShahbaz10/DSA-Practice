package BinarySearchTreePractice;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;



public class BottomView {

    static class Node {
        int hd;
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    private void bottomView(Node root) {

        if (root == null) {
            return;
        }
        class MyQueue {
            Node node;
            int hd;

            MyQueue(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<MyQueue> queue = new LinkedList<>();
        Map<Integer, Node> bottomViewMap = new TreeMap<>();

        queue.add(new MyQueue(root, 0));

        while (!queue.isEmpty()) {
            MyQueue tempNode = queue.poll();
            bottomViewMap.put(tempNode.hd, tempNode.node);

            if (tempNode.node.left != null) {
                queue.add(new MyQueue(tempNode.node.left,tempNode.hd - 1));
            }
            if (tempNode.node.right != null) {
                queue.add(new MyQueue(tempNode.node.right,tempNode.hd + 1));
            }
        }
        System.out.println("Bottom view of Binary Tree: ");
        for (Map.Entry<Integer, Node> entry: bottomViewMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    private void bottomViewAlternate(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> bottomViewMap = new TreeMap<>();

        root.hd = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            bottomViewMap.put(tempNode.hd, tempNode);

            if (tempNode.left != null) {
                tempNode.left.hd = tempNode.hd - 1;
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                tempNode.right.hd = tempNode.hd + 1;
                queue.add(tempNode.right);
            }
        }
        System.out.println();
        System.out.println("Bottom view of Binary Tree alternate approach: ");
        for (Map.Entry<Integer, Node> entry: bottomViewMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    public static void main(String[] args) {

        BottomView tree = new BottomView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        tree.bottomView(tree.root);
        tree.bottomViewAlternate(tree.root);
    }
}


/* Create following Binary Tree
  1
/   \
2     3
 \
  4
    \
     5
      \
       6

TOP VIEW => 2, 1, 3, 6
BOTTOM VIEW => 2, 4, 5, 6
*/

