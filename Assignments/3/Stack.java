/**
 * FIFO Stack class using generic, doubly linked Node<T> objects 
 * @author Luca Nicotra
 */
public class Stack<T> {
     private Node<T> end, root;
     
     /**
      * Constructor
      */
     public Stack(){}

     /**
      * Adds Node to top of Stack
      * @param newNode
      */
     public void push(Node<T> newNode){
          Node<T> temp = root;
          if(root != null){
               while(temp.next != null){
                    temp = temp.next;
               }
               temp.next = newNode;
               newNode.prev = temp;
               end = newNode;
          }else if(root == null){
               root = end = newNode;
          }
     }

     /**
      * Removes and returns Node at top of Stack
      * @return
      */
     public Node<T> pop(){
          Node<T> temp;
          if(end != null && end != root){
               temp = end.prev.next;
               end.prev.next = null;
          }else if(end != null && end == root){
               temp = root;
               root = end = null;
          }else{
               return null;
          }
          return temp;
     }

     /**
      * Returns Node at top of Stack
      * @return
      */
     public Node<T> peek(){
          return end;
     }
}
