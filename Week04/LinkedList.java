public class LinkedList {
     private Node root;
     private Node end;

     public LinkedList(){

     }

     public String removeNodeAt(int index){
          Node temp = root;
          if(index == 0){
               if(root.next == null){
                    String str = root.val;
                    root = null;
                    return "Removed " + str;
               }
               String str = root.val;
               root = root.next;
               return "Removed " + str;
          }
          //Runs until reaches Node preceding index
          for(int i = 0; i < index-1; i++){
               if(temp.next == null && i+1 != index) return "";
               temp = temp.next;
          }
          if(temp.next == null) return "";
          if(temp.next.next == null){
               temp.next = null;
               return "";
          }else{
               String str = temp.next.val;
               temp.next = temp.next.next;
               return "Removed " + str;
          }
     }

     public void add(String data){
          Node temp = root;
          if(root == null){ //Empty list
               root = new Node(data);
          }else if(root.next == null){ //List length 1
               if(data.compareTo(temp.val) < 0){
                    root = new Node(data, temp);
               }else{
                    temp.next = new Node(data);
               }
          }else{ //List length >= 2
               if(temp.val.compareTo(data) > 0){ //if goes first in list
                    root = new Node(data, temp);
                    return;
               }
               while(temp.next != null){
                    if(temp.next.val.compareTo(data) > 0){
                         temp.next = new Node(data, temp.next); //?
                         return;
                    }
                    temp = temp.next;
               }
               temp.next = new Node(data);
          }
          
     }

     public boolean remove(String data){
          Node temp = root;
          //if list is empty
          if(root == null) return false;
          //if list length is 1
          if((root == end) && (root.val == data)){
               root = null;
               end = null;
               return true;
          }
          //if list length is >= 2
          while(temp.next != null){
               if(temp.next.val == data){
                    if(temp.next.next != null){
                         temp.next = temp.next.next;
                         return true;
                    }
                    temp.next = null;
                    return true;
               }
               temp = temp.next;
          }
          return false;
     }

     // Needs alteration
     public int indexOf(String string){
          if(root == null) return Integer.MIN_VALUE;
          if(root.next == null) return Integer.MIN_VALUE;
          int count = 0;
          Node temp = root;
          while(temp.next != null){
               if(temp.val.equals(string)) return count;
               count++;
               temp = temp.next;
          }
          if(temp.val.equals(string)) return count;
          return Integer.MIN_VALUE;
     }

     public String toString(){
          Node temp = root;
          if(root == null){//Length 0
               return "[Empty List]";
          }else if(root == end){//Length 1
               return "[" + temp.val + "]";
          }else{//Length 2+
               String fin = "[";
               while(temp.next!= null){
                    fin += temp.val + ", ";
                    temp = temp.next;
               }
               fin += temp.val + "]";
               return fin;
          }
     }
}
