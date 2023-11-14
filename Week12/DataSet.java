import java.util.*;

public class DataSet {
     int[] data = new int[1000000];

     public DataSet(){
          for(int i = 0; i < data.length; i++){
               data[i] = (int)(Math.random() * 10);
          }
          Arrays.sort(data);
     }

     int findValueRecurse(int value, int low, int high){
          if (high >= low && low <= data.length - 1) {
              int mid = low + (high - low) / 2;
              if (data[mid] == value) return mid;
  
              if (data[mid] > value) return findValueRecurse(value, low, mid - 1);
  
              return findValueRecurse(value, mid + 1, high);
          }
  
          return -1;
     }
     
     int binarySearch(int x){
        int length = 0;
        int cap = data.length - 1;
 
        while (length <= cap) {
            int mid = length + (cap - length) / 2;
 
            if(data[mid] == x) return mid;
            if(data[mid] < x) length = mid + 1;
            if(data[mid] > x) cap = mid - 1;
        }
 
        return -1;
     }

     public void print(){
          for(int i : data) System.out.println(i);
     }
}

