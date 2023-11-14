public class Driver{
     public static void main(String[] s){
          DataSet data = new DataSet();
          //data.print();

          double start = System.nanoTime();
          for(int i = 0; i < 10000; i++){
               data.findValueRecurse((int)(Math.random()*10), 0, data.data.length);
          }
          double end = System.nanoTime();
          System.out.println("Average recursive time: " + (end-start)/10000 + " nanoseconds");

          start = System.nanoTime();
          for(int i = 0; i < 10000; i++){
               data.binarySearch((int)(Math.random()*10));
          }
          end = System.nanoTime();
          System.out.println("Average explicit time: " + (end-start)/10000 + " nanoseconds");


     }

}