import java.util.*;

public class DoublyLinkedList<E extends Comparable<E>> implements Iterable<Node<E>> {
     private Node<E> root, end;
     
     public DoublyLinkedList(){}

     public DoublyLinkedList(Comparator<E> comparator){}

     public void add(Node<E> newNode){
          if(root == null){ //empty list
               root = end = newNode;
          }else if(root.data.compareTo(newNode.data) >= 0){ //if newNode precedes root
               Node<E> temp = root;
               root = newNode;
               temp.prev = newNode;
               newNode.next = temp;
          }else{
               Node<E> temp = root;
               while(temp != end && newNode.data.compareTo(temp.next.data) > 0){
                    temp = temp.next;
               }//end while
               if(temp == end){
                    end.next = newNode;
                    newNode.prev = end;
                    end = end.next;
               }else{
                    newNode.prev = temp;
                    newNode.next = temp.next;
                    temp.next = newNode;
                    newNode.next.prev = newNode;
               }
          }
     }

     public void print(){
          Node<E> temp = root;
          System.out.print("[");
          while(temp != end){
               System.out.print("{" + temp.data + "}, ");
               temp = temp.next;
          }
          System.out.print("{" + temp.data + "}]");
     }

     public Iterator<Node<E>> iterator(){
          return new MyListIterator<E>();
     }

     private class MyListIterator<T> implements Iterator<Node<E>>{
          Node<E> cursor;

          public MyListIterator(){
               cursor = root.next;
          }
          public boolean hasNext(){
               if(cursor == null || cursor.next == null) return false;
               return true;
          }
          public Node<E> next(){
               Node<E> temp = cursor;
               cursor = cursor.next;
               return temp;
               //returns current, moves cursor to next
          }
     }//end ListIterator


}
