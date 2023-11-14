public class Deque<T> {
     private Node<T> first, last;

     public Deque(){}

     public void addFirst(Node<T> newNode){
          Node<T> temp = first;
          if(first == null){ //empty deque
               first = last = newNode;
          }else{ //1+ element deque
               first = newNode;
               newNode.next = temp;
               temp.prev = newNode;
          }
     }

     public void addLast(Node<T> newNode){
          Node<T> temp = last;
          if(first == null){ //empty deque
               first = last = newNode;
          }else{ //1 element deque
               last = newNode;
               newNode.prev = temp;
               temp.next = newNode;
          }
     }

     public Node<T> peekFirst(){
          return first;
     }

     public Node<T> peekLast(){
          return last;
     }

     public Node<T> popFirst(){
          Node<T> temp = first;
          if(first == null) return null;
          if(first == last){
               first = last = null;
          }else{
               first = first.next;
               first.prev = null;
          }
          return temp;
     }

     public Node<T> popLast(){
          Node<T> temp = last;
          if(last == null) return null;
          if(first == last){
               first = last = null;
          }else{
               last = last.prev;
               last.next = null;
          }
          return temp;
     }
}
