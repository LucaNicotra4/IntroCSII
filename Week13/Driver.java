import java.util.*;

public class Driver {
     public static void main(String[] s){
          HashMap<String, Student> students = new HashMap<>();
          int studs = KeyboardReader.readInt("How many students? ");
          for(int i = 0; i < studs; i++){
               String fname = KeyboardReader.readLine("Enter first name: ");
               while(students.containsKey(fname)){
                    System.out.println("Name in use, reenter first name: ");
                    fname = KeyboardReader.readLine("Enter first name: ");
               }
               String lname = KeyboardReader.readLine("Enter last name: ");
               String dorm = KeyboardReader.readLine("Enter dorm name: ");
               Student stu = new Student(fname, lname, dorm);
               students.put(fname, stu);
          }
          Set<String> set = students.keySet();

          for(String str : set){
               System.out.println(students.get(str));
          }
     }
}
