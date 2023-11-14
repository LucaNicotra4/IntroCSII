import java.lang.*;
public class Driver {
     public static void main(String[] s){
          BagOfInts bag = fillBag(10);
          BagOfInts bag2 = fillBag(10);
          BagOfInts bag3 = new BagOfInts();
          bag3.add(1);
          bag3.add(2);
          BagOfInts bag4 = new BagOfInts();
          bag4.add(1);
          bag4.add(1);
          bag4.add(2);
          System.out.print("Bag: ");
          bag.print();
          System.out.print("Bag2: ");
          bag2.print();

          bag.retainAll(bag2);
          bag.print();
          System.out.print("Equals: " + bag3.equals(bag4));

     }

     public static BagOfInts fillBag(int values){
          BagOfInts bag = new BagOfInts();
          for(int i = 0; i < values; i++){
               bag.add((int)(Math.random() * 10));
          }
          return bag;
     }
}
