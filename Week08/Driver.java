import java.util.*;
import java.lang.*;

public class Driver {
     public static void main(String[] a){
          //numberformatexception
          String infix = KeyboardReader.readLine("Enter algorithm: ");
          System.out.println(infix);
     }

     public static String toPostfix(String infix){ //assume all nums 1 digit
          ArrayList<String> nums = new ArrayList<String>
               (Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
          ArrayList<String> opps = new ArrayList<String>
               (Arrays.asList("+", "-", "/", "*"));

          String postfix = "";
          Stack stack = new Stack();
          boolean prths = false;

          for(int i = 0; i < infix.length(); i++){ //Scan from left to right
               String temp = infix.substring(i, i+1);
               if(nums.contains(temp)){
                    postfix += temp;
               }else{

               }
          }


          return postfix;
     }
}

//if(temp.equals(" ")) continue;
// if(nums.contains(temp)){ //if a number
     
// }else if(opps.contains(temp)){ //if an operati
// }else{
//      prths = !prths;
// }
