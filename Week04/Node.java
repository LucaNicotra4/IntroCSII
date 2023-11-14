public class Node{
     protected String val;
     protected Node next;

     public Node(String val){
          this.val = val;
     }

     public Node(String val, Node next){
          this.val = val;
          this.next = next;
     }
}