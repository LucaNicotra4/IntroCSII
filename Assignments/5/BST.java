import java.util.*;

public class BST<E extends Comparable<E>> {
    private Node<E> root;

    public void add(E data) {
        if (root != null) {
            add(root, data);
        } else {
            root = new Node<>(data);
        }
    }

    private void add(Node<E> current, E data) {
        int result = data.compareTo(current.data);
        if (result < 0) {
            if (current.left != null) {
                add(current.left, data);
            } else {
                current.left = new Node<>(data);
            }
        } else if (result > 0) {
            if (current.right != null) {
                add(current.right, data);
            } else {
                current.right = new Node<>(data);
            }
        }
    }

    public boolean contains(E data) {
        return contains(root, data);
    }

    private boolean contains(Node<E> current, E data) {
        if (current == null) {
            return false;
        }
        int result = data.compareTo(current.data);
        if (result < 0) {
            return contains(current.left, data);
        } else if (result > 0) {
            return contains(current.right, data);
        }
        return true;
    }

    public void printRecursive() {
        if (root != null) {
            print(root);
        } else {
            System.out.println("Empty Tree :(");
        }
    }

    private void print(Node<E> current) {
        if (current != null) {
            print(current.left);
            System.out.println(current.data);
            print(current.right);
        }
    }
    public void printExplicit(){
        if(root == null) return;
        Node<E> current = root;
        Stack<Node<E>> stack = new Stack<>();
        while(current != null || stack.size() > 0){
            while(current.left != null){
                stack.push(root);
                current = current.left;
            }
            current = stack.pop();
            System.out.println(current);
            current = current.right;
        }
    }
 }