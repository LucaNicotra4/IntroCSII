/**
 * Intro to CS II Assignment 1
 * Populating two arrays, combining into third
 * 
 * @author Luca Nicotra
 */
import java.util.*;
public class Driver{
     public static void main(String[] s){
          //declare and fill arrays
          int size = KeyboardReader.readInt("Enter size of first array: ");
          int[] arr1 = new int[size];
          size = KeyboardReader.readInt("Enter size of second array: ");
          int[] arr2 = new int[size];
          System.out.println("Fill array 1: ");
          for(int i = 0; i < arr1.length; i++){
               arr1[i] = KeyboardReader.readInt("Index " + i + ": ");
          }
          System.out.println("Fill array 2: ");
          for(int i = 0; i < arr2.length; i++){
               arr2[i] = KeyboardReader.readInt("Index " + i + ": ");
          }
          int[] arr3 = new int[arr1.length + arr2.length];
          
          //Begin sorting process for arrays
          Arrays.sort(arr1);
          Arrays.sort(arr2);
          int index1 = 0;
          int index2 = 0;
          for(int i = 0; i < arr3.length; i++){
               if(index1 < arr1.length && index2 < arr2.length){
                    if(arr1[index1] <= arr2[index2]){
                    arr3[i] = arr1[index1++];
                    }else{
                    arr3[i] = arr2[index2++];
                    }
               }else if(index1 == arr1.length){
                    arr3[i] = arr2[index2++];
               }else{
                    arr3[i] = arr1[index1++];
               }
               }
          
          //print final array
          for(int i = 0; i < arr3.length; i++){
               System.out.print(arr3[i] + ", ");
          }
     }
}