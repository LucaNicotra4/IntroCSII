public class Student{
     private String fname, lname, dorm;

     public Student(String fname, String lname, String dorm){
          this.fname = fname;
          this.lname = lname;
          this.dorm = dorm;
     }

     public String getFirstName(){
          return this.fname;
     }

     public String getLastName(){
          return this.lname;
     }

     public String getDorm(){
          return dorm;
     }

     public String toString(){
          return lname + ", " + fname + ". Dorm: " + dorm;
     }
}