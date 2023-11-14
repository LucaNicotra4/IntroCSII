public class Driver{
     public static void main(String[] args){
          solveTowers(3, 1, 3, 2);
     }

     //solve for 3, need 2, solve for 2, need 1
     public static void solveTowers(int numDisks, int startingPeg, int endingPeg, int tempPeg){
          if(numDisks == 0) return;

          solveTowers(numDisks - 1, startingPeg, tempPeg, endingPeg);
          System.out.println(startingPeg + " -> " + endingPeg);
          solveTowers(numDisks - 1, tempPeg, endingPeg, startingPeg);
     }
}