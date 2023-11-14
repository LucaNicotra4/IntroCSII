/**
 * LIFO Queue class using generic, doubly linked Node<T> objects
 * @author Luca Nicotra
 */
public class Queue<T> {
     private Node<T> first, last;

     public Queue(){}

     public void push(Node<T> newNode){
          if(first == null){ //adding to empty queue
               first = last = newNode;
          }else{ //adding to end of queue with elements
               Node<T> temp = first;
               while(temp != last){
                    temp = temp.next;
               }
               temp.next = newNode;
               newNode.prev = temp;
               last = newNode;
          }
     }

     public Node<T> pop(){
          Node<T> temp = first;
          if(first == null) return null;
          if(first == last){
               first = last = null;
          }else{
               first = temp.next;
               first.prev = null;
          }
          return temp;
     }

     public Node<T> peek(){
          return first;
     }
}
