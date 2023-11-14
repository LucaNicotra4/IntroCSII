public class Driver {
     
     public static void main(String[] args){
          clearScreen();
          Student[] students = takeInput();
          clearScreen();
          compareStudentObjects(students);
          System.out.println();
          compareStudentHashCodes(students);
     }

     //creates and returns an array of student objects
     public static Student[] takeInput(){
          Student[] students = new Student[3];

          for(int i = 0; i < 3; i++){
               String fname = null, lname = null;
               int studentID, coursesTaken;
               fname = KeyboardReader.readLine("Enter first name: ");
               lname = KeyboardReader.readLine("Enter last name: ");
               studentID = KeyboardReader.readInt("Enter studentID: ");
               coursesTaken = KeyboardReader.readInt("Enter courses taken: ");
               students[i] = new Student(fname, lname, studentID, coursesTaken);
               clearScreen();
          }
          return students;
     }

     //prints toString of each student object in students array
     public static void printStudents(Student[] students){
          for(int i = 0; i < students.length; i++){
               System.out.println(students[i]);
          }
     }

     //compares student objects in student array using student equals() method
     public static void compareStudentObjects(Student[] students){
          for(int i = 0; i < students.length; i++){
               for(int j = i + 1; j < students.length; j++){
                    System.out.print("Student " + i + " and Student " + j + " equal? ");
                    System.out.print(students[i].equals(students[j]));
                    System.out.println();
               }
          }
     }

     //compares student hashCodes in student array
     public static void compareStudentHashCodes(Student[] students){
          for(int i = 0; i < students.length; i++){
               for(int j = i + 1; j < students.length; j++){
                    System.out.print("Student " + i + " hashCode (" + students[i].hashCode() + ") and Student " + j + " hashCode (" + students[j].hashCode() + ") equal? ");
                    System.out.print(students[i].equals(students[j]));
                    System.out.println();
               }
          }
     }

     //clears console
     public static void clearScreen() {  
          System.out.print("\033[H\033[2J");  
          System.out.flush();  
      }

}
