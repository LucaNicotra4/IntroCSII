public class Node<D extends Comparable<D>> {
    public Node<D> left;
    public Node<D> right;
    public D data;

    public Node(D data) {
        this.data = data;
    }
}