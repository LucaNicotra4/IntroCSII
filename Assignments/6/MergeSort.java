import java.util.*;

public class MergeSort {

    public static void mergeSortExplicit(int[] array){
        if(array.length <= 1) return;
        for(int i = 1; i < array.length; i *= 2){ //double max size each time
            for(int left = 0; left < array.length; left += 2*i){ //creating a "new array" every i indexes of array
                int mid = Math.min(left + i - 1, array.length - 1); //endpoint of left array && starting point of right (mid + 1) ///////////////
                int right = Math.min(left + (2*i) - 1, array.length - 1);
                merge(array, left, mid, right);
            }
        }
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int[] temp = new int[end - start + 1];
        int tempIndex = 0;

        while (leftIndex <= mid && rightIndex <= end) {
            // if (array[leftIndex] < array[rightIndex]) {
            //     temp[tempIndex++] = array[leftIndex++];
            // } else {
            //     temp[tempIndex++] = array[rightIndex++];
            // }

            temp[tempIndex++] = (array[leftIndex] < array[rightIndex]) ? array[leftIndex++] : array[rightIndex++];
            // temp[tempIndex++] = array[(array[leftIndex] < array[rightIndex]) ? leftIndex++ : rightIndex++];
        }

        if (leftIndex <= mid) {
            System.arraycopy(array, leftIndex, temp, tempIndex, mid - leftIndex + 1);
        }

        if (rightIndex <= end) {
            System.arraycopy(array, rightIndex, temp, tempIndex, end - rightIndex + 1);
        }

        System.arraycopy(temp, 0, array, start, end - start + 1);

    }

    public static final void main(String[] args) {
        Random random = new Random();
        int[] original = new int[10000000];
        for (int i = 0; i < original.length; i++) {
            original[i] = random.nextInt(original.length * 10);
        }
        int[] working1 = new int[original.length];
        System.arraycopy(original, 0, working1, 0, original.length);
        int[] working2 = new int[original.length];
        System.arraycopy(original, 0, working2, 0, original.length);

        long startTime = 0, endTime = 0;

        startTime = System.nanoTime();
        Arrays.sort(original);
        endTime = System.nanoTime();
        System.out.println("Arrays.sort() took " + ((endTime - startTime) / 1E6) + " milliseconds");

        startTime = System.nanoTime();
        mergeSort(working1, 0, working1.length - 1);
        endTime = System.nanoTime();
        System.out.println("MergeSort took " + ((endTime - startTime) / 1E6) + " milliseconds");

        startTime = System.nanoTime();
        mergeSortExplicit(working2);
        endTime = System.nanoTime();
        System.out.println("MergeSortExplicit took " + ((endTime - startTime) / 1E6) + " milliseconds");

        if (!Arrays.equals(original, working1) || !Arrays.equals(original, working2)) {
            System.out.println("There is an error");
        } else {
            System.out.println("Sorts Work!");
        }

        // for(int x : original) System.out.print(x + ", ");
        // System.out.println();
        // for(int x : working2) System.out.print(x + ", ");
    }

}