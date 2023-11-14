public class Stack{
     String[] data;
     int index;

     public Stack(){
          data = new String[1000];
          index = 0;
     }

     public void push(String string){
          data[index] = string;
          index++;
     }

     public void pop(String string){
          data[index] = null;
          index--;
     }

     public String peek(){
          return data[index];
     }

}