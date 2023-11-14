public class Driver {
    public static final void main(String[] args) {
        BST<Integer> stringTree = new BST<>();
        for (int i = 0; i < 10000; i++) {
            stringTree.add(i);
        }
        stringTree.printRecursive();
    }
}