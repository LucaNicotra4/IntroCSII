/**
 * Node class with next and prev pointers, 
 * meant for doubly linked list
 * @author Luca Nicotra
 */
public class Node<T>{
     protected T data;
     protected Node<T> next, prev;

     /**
      * Constructor
      * @param data
      */
     public Node(T data){
          this.data = data;
     }
}