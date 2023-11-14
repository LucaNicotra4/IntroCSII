import java.util.*;
import java.io.*;

public class Driver {
     public static void main(String[] args){
          DoublyLinkedList<Student> list = buildList();
          //list.print();

          for(Node<Student> s : list) {
               System.out.println(s.data);
          }
     }

     public static DoublyLinkedList<Student> buildList(){
          DoublyLinkedList<Student> list = new DoublyLinkedList<Student>();
          try{
               File file = new File("student_data.txt");
               Scanner myReader = new Scanner(file);
               while(myReader.hasNextLine()){
                    long id = Long.valueOf(myReader.nextLine());
                    String fname = myReader.nextLine();
                    String lname = myReader.nextLine();
                    float gpa = Float.valueOf(myReader.nextLine());
                    Student student = new Student(id, fname, lname, gpa);
                    list.add(new Node<Student>(student));
               }
               myReader.close();
          }catch(Exception e){
               System.out.println("Exception ocurred");
          }
          return list;
     }
}
