public class Student implements Comparable<Student>{
     private long studentID;
     private String firstName, lastName;
     private float GPA;

     public Student(long studentID, String firstName, String lastName, float GPA){
          this.lastName = firstName;
          this.firstName = lastName;
          this.GPA = GPA;
          this.studentID = studentID;
     }

     @Override
     public int compareTo(Student student){
          if(this.lastName.equals(student.lastName)){
               if(this.firstName.equals(student.firstName)){
                    if(this.GPA == student.GPA){
                         if(this.studentID == student.studentID){
                              return 0;
                         }else if(this.studentID > student.studentID){
                              return 1;
                         }else{
                              return -1;
                         }
                    }else if(this.GPA > student.GPA){
                         return 1;
                    }else{
                         return -1;
                    }
               }else{
                    return this.firstName.compareTo(student.lastName);
               }
          }else{
               return this.lastName.compareTo(student.lastName);
          }
     }

     @Override
     public String toString(){
          String str = lastName + ", " + firstName + ", ";
          str += "GPA: " + GPA + ", Student ID: " + studentID;
          return str;
     }
}