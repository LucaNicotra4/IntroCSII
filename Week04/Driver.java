public class Driver {
     public static void main(String[] s){
          LinkedList list = new LinkedList();
          list = fillList();
          System.out.println(list);
          list.remove("company");
          System.out.println(list);
          list.removeNodeAt(3);
          System.out.println(list);
          int x = list.indexOf("apple");
          System.out.println(x);
          System.out.println(list.indexOf("xanax"));
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
