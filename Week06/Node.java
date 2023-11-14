public class Node<E>{
     protected E data;
     protected Node<E> next, prev;

     public Node(){}

     public Node(E data){
          this.data = data;
     }

     public Node(E data, Node<E> next, Node<E> prev){
          this.data = data;
          this.next = next;
          this.prev = prev;
     }

}
