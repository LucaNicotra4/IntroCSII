import java.lang.reflect.*;
import java.util.*;
import java.lang.*;

public class Driver{
     public static void main(String[] args) throws ClassNotFoundException{        
          Class className = Class.forName(KeyboardReader.readLine("Enter class name: "));

          System.out.println("Printing Explicit: ");
          printInheritanceTreeExplicit(className);
          System.out.println("Printing Explicit Backwards: ");
          printInheritanceTreeExplicitBackwards(className);

          System.out.println("Printing Recursive: ");
          printInheritanceTreeRecursive(className);
          System.out.println("Printing Recursive Backwards: ");
          printInheritanceTreeRecursiveBackwards(className);
     }


     public static void printInheritanceTreeRecursive(Class className) throws ClassNotFoundException{
          try{
               System.out.println(className);
               if(className.getSuperclass() != null) 
                    printInheritanceTreeRecursive(className.getSuperclass());
          }catch(ClassNotFoundException e){
               System.out.println("Class not found");
          }
     }

     public static void printInheritanceTreeRecursiveBackwards(Class className) throws ClassNotFoundException{
          try{
               if(className.getSuperclass() != null) 
                    printInheritanceTreeRecursiveBackwards(className.getSuperclass());
               System.out.println(className);
          }catch(ClassNotFoundException e){
               System.out.println("Class not found");
          }
     }

     public static void printInheritanceTreeExplicit(Class className){
               while(className.getSuperclass() != null){
                    System.out.println(className);
                    className = className.getSuperclass();
               }
               System.out.println(className);
     }

     public static void printInheritanceTreeExplicitBackwards(Class className){
          Stack<Class> stack = new Stack<>();
          printInheritanceTreeExplicitBackwards(className, stack);
     }

     private static void printInheritanceTreeExplicitBackwards(Class className, Stack<Class> stack){
          while(className.getSuperclass() != null){
               stack.push(className);
               className = className.getSuperclass();
          }
          stack.push(className);
          while(stack.size() > 0){
               System.out.println(stack.pop());
          }
     }
}