import java.lang.Math;

public class Driver {
     public static void main(String[] s){
          float[][] arr = create2DArray();
          print2DArray(arr);
          System.out.println();
          printMeanOfEachArray(arr);
          printTotalMean(arr);
          System.out.println();
          System.out.println("Rearranging Data...");
          arr = rearrangeData(arr);
          print2DArray(arr);
     }

     public static float[][] create2DArray(){
          clearScreen();
          int size = KeyboardReader.readInt("How many arrays would you like to create? ");
          float[][] arr = new float[size][];
          for(int i = 0; i < size; i++){
               int size2 = KeyboardReader.readInt("Enter size of array " + (i) + ": ");
               arr[i] = new float[size2];
          }
          clearScreen();
          for(int i = 0; i < arr.length; i++){
               System.out.println("Enter values for array " + i + ":");
               for(int j = 0; j < arr[i].length; j++){
                    arr[i][j] = KeyboardReader.readFloat("Index " + j + ": ");
               }
               clearScreen();
          }
          return arr;
     }

     public static void print2DArray(float[][] arr){
          for(int i = 0; i < arr.length; i++){
               System.out.println("Array " + i + ": ");
               System.out.print("[");
               for(int j = 0; j < arr[i].length - 1; j++){
                    System.out.print(arr[i][j] + ", ");
               }
               System.out.print(arr[i][arr[i].length-1] + "]");
               System.out.println();
          }
     }

     public static void printMeanOfEachArray(float[][] arr){
          for(int i = 0; i < arr.length; i++){
               double sum = 0;
               for(int j = 0; j < arr[i].length; j++){
                    sum += arr[i][j];
               }
               double length = (double)(arr[i].length);
               double avg = (double)(sum/length);
               System.out.println("Array " + i + " mean: " + avg);
          }
     }

     public static void printTotalMean(float[][] arr){
          double sum = 0;
          double count = 0;
          for(int i = 0; i < arr.length; i++){
               for(int j = 0; j < arr[i].length; j++){
                    sum += arr[i][j];
                    count++;
               }
          }
          double avg = (double)(sum / count);
          System.out.println("Mean of all arrays: " + avg);
     }

     public static float[][] rearrangeData(float[][] arr){
          float[][] temp = new float[arr.length][];

          for(int i = 0; i < temp.length; i++){
               temp[i] = new float[arr[i].length];
               for(int j = 0; j < temp[i].length; j++){
                    int x = (int)(Math.random() * temp[i].length);
                    while(temp[i][x] != 0){
                         x = (int)(Math.random() * temp[i].length);
                    }
                    temp[i][x] = arr[i][j];
               }
          }
          return temp;
     }

     //needs revision
     public static void compareArrays(float[][] arr1, float[][] arr2){
          for(int i = 0; i < arr1.length; i++){
               for(int j = 0; j < arr1.length; j++){
                    if(arr1[i][j] != arr2[i][j]){
                         System.out.println("Arrays " + i + " are not equal");
                         break;
                    }
                    System.out.println("Arrays " + i + " are equal");
               }
          }
     }

     public static void clearScreen() {  
          System.out.print("\033[H\033[2J");  
          System.out.flush();  
      }
}
