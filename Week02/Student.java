public class Student {
     private String fname;
     private String lname;
     private int studentID;
     private int coursesTaken;

     public Student(String fname, String lname, int studentID, int coursesTaken){
          this.fname = fname;
          this.lname = lname;
          this.studentID = studentID;
          this.coursesTaken = coursesTaken;
     }

     @Override
     public boolean equals(Object object){
          if(object == null) return false;
          if(object == this) return true;

          if(object instanceof Student){
               Student s = (Student) object;
               if(this.toString().equals(s.toString()) && this.studentID == (s.studentID)){
                    return true;
               }               
          }

          return false;
     }

     @Override
     public int hashCode() {
          long hCode = 17;
          hCode = 31 * hCode + Long.hashCode(studentID);
          hCode = 31 * hCode + this.toString().hashCode();
          
          return Long.hashCode(hCode);
     }

     @Override
     public String toString(){
          return fname + " " + lname;
     }
}
