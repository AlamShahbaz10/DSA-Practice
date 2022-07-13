package BST;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

    private Node<T> root;

    @Override
    public void insert(T data) {

        if(root == null){
            root = new Node<>(data, null);
        }
        else{
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {
        //go to left sub treee
        if(node.getData().compareTo(data) > 0){
            if(node.getLeftChild()!=null){
                insert(data, node.getLeftChild());
            }
            else{
                Node<T> leftChild = new Node<>(data, node);
                node.setLeftChild(leftChild);
            }
        }
        //go to right sub tree
//        if(node.getData().compareTo(data) < 0)
        else{
            if(node.getRightChild()!=null){
                insert(data, node.getRightChild());
            }
            else{
                Node<T> rightChild = new Node<>(data, node);
                node.setRightChild(rightChild);
            }
        }
    }

    @Override
    public void remove(T data) {

    }

    //In order traversal (SORTED order) -> left, root, right
    @Override
    public void traversal() {
        if(root == null) return;

        traversal(root);
    }

    private void traversal(Node<T> node) {
        if(node.getLeftChild()!=null){
            traversal(node.getLeftChild());
        }

        System.out.print(node + " -> ");

        if(node.getRightChild()!=null){
            traversal(node.getRightChild());
        }
    }

    @Override
    public T min() {
        if(root == null) return null;
        return min(root);
    }


    //min(10) => min(5) => min(-1)
    //-1

    private T min(Node<T> node) {
        if(node.getLeftChild() != null){
            return min(node.getLeftChild()); //10, 5, -1
        }
        return node.getData();
    }

    @Override
    public T max() {
        if(root == null) return null;

        return max(root);
    }

    private T max(Node<T> node) {
        if(node.getRightChild() != null){
          return max(node.getRightChild());
        }
        return node.getData();
    }
}
