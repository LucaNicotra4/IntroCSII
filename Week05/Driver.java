
public class Driver {
     public static void main(String[] args){ 
          LinkedList list = new LinkedList();
          list = fillList();

          for(Node s : list){
               System.out.print(s.val + ", ");
          }

     }

     public static LinkedList fillList(){
          LinkedList list = new LinkedList();
          list.add("box");
          list.add("xanax");
          list.add("jungle");
          list.add("cart");
          list.add("apple");
          list.add("company");

          return list;
     }
}
