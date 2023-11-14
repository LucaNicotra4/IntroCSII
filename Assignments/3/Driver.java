public class Driver {
     public static void main(String[] args){
          Node<String> first = new Node<>("A");
          Node<String> second = new Node<>("B");
          Node<String> third = new Node<>("C");
          Node<String> fourth = new Node<>("D");

          //Stack<String> stack = new Stack<>();
          //System.out.println(stack.peek());

          Queue<String> queue = new Queue<>();
          queue.push(first);
          queue.push(second);
          queue.push(third);
          queue.push(fourth);
          Node<String> temp = queue.pop();
          while(temp != null){
               System.out.println(temp.data);
               temp = queue.pop();
          }

          Deque<String> deque = new Deque<>();
          deque.addFirst(first);
          deque.addLast(second);
          deque.addLast(third);
          deque.addFirst(fourth);
          temp = deque.popFirst();
          while(temp != null){
               System.out.println(temp.data);
               temp = deque.popFirst();
          }

     }
}
