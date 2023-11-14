//import csci1140.*;
//keegangress@icloud.com

public class BinaryTree<D extends Comparable<D>> {
    private Node<D> root;

    public void inOrderPrint() {
        inOrderPrint(root);
    }

    private void inOrderPrint(Node<D> current) {
        if (current != null) {
            inOrderPrint(current.left);
            System.out.println(current.data);
            inOrderPrint(current.right);
        }
    }

    public boolean add(D newData) {
        Node<D> newNode = new Node<>(newData);
        if (root == null) {
            root = newNode;
            return true;
        }
        return add(root, newNode);
    }

    private boolean add(Node<D> current, Node<D> newNode) {
        int direction = newNode.data.compareTo(current.data);
        if (direction == 0) {
            return false;
        }
        if (direction < 0) {
            if (current.left == null) {
                current.left = newNode;
                return true;
            } else {
                return add(current.left, newNode);
            }
        } else {
            if (current.right == null) {
                current.right = newNode;
                return true;
            } else {
                return add(current.right, newNode);
            }
        }
    }

    //need two cursors
    public D removeSmallest(){
        if(root == null){ //if tree is empty
            return null;
        }else if(root.left == null){ //if root is the smallest value
            Node<D> temp = root.left;
            if(root.right == null){
                root = null;
                return temp.data;
            }else{
                root = root.right;
                return temp.data;
            }
        }else{ //parse down left side
            Node<D> lead = root.left;
            Node<D> trail = root;
            while(lead.left != null){
                lead = lead.left;
                trail = trail.left;
            }
            if(lead.right != null){
                trail.left = lead.right;
                return lead.data;
            }else{
                trail.left = null;
                return lead.data;
            }
        }
    }

    public int calculateDepth(){
        return calculateDepth(root);
    }

    private int calculateDepth(Node<D> root){
        if(root == null) return 0;
        int leftDepth = calculateDepth(root.left);
        int rightDepth = calculateDepth(root.right);
        if(leftDepth > rightDepth){
            return leftDepth + 1;
        } else{
            return rightDepth +1;
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.add(3);
        tree.add(2);
        tree.add(47);
        tree.add(1);
        tree.add(13);
        tree.add(72);

        tree.inOrderPrint();
        System.out.println(tree.calculateDepth());
    }
}