package BinarySearchTreePractice;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;



public class TopView {

    static class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }
    }
    Node root;

    private void topView(Node root)
    {
        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd)
            {
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<QueueObj> q = new LinkedList<>();
        Map<Integer, Node> topViewMap = new TreeMap<>();

        if (root == null) {
            return;
        }
        else {
            q.add(new QueueObj(root, 0));
        }

        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }

            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left,tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right,tmpNode.hd + 1));
            }
        }
        for (Map.Entry<Integer, Node> entry: topViewMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args) {

        TopView tree = new TopView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        tree.topView(tree.root);
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
*/

