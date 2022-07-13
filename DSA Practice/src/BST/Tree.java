package BST;

public interface Tree<T> {
    void insert(T data);
    void remove(T data);
    void traversal(); //in-order
    T min();
    T max();
}
