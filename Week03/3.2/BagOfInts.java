import java.util.*;

public class BagOfInts {
    private int[] array;
    private int lastUsedIndex;
    private Random random;

    public BagOfInts() {
        array = new int[493];
        lastUsedIndex = -1;
        random = new Random();
    }

    public boolean equals(Object obj){
        if(!(obj instanceof BagOfInts)) return false;
        BagOfInts anotherBag = (BagOfInts) obj;
        for(int i = 0; i < this.size(); i++){
            if(!(anotherBag.contains(this.array[i]))) return false;
        }
        for(int i = 0; i < anotherBag.size(); i++){
            if(!(this.contains(anotherBag.array[i]))) return false;
        }
         return true;
    }

    public void retainAll(BagOfInts anotherBag){
        int[] temp = new int[this.size()];
        int length = this.size();
        lastUsedIndex = -1;
        for(int i = 0; i < length; i++){
            if(anotherBag.contains(this.array[i])) temp[++lastUsedIndex] = this.array[i];
        }
        this.array = temp;
    }

    public void addAll(BagOfInts anotherBag){
        int[] temp = new int[(this.size() + anotherBag.size())];
        int length = this.size();
        lastUsedIndex = -1;
        for(int i = 0; i < length; i++){
            temp[(lastUsedIndex+1)] = this.array[i];
            lastUsedIndex++;
        }
        for(int i = 0; i < anotherBag.size(); i++){
            temp[(lastUsedIndex+1)] = anotherBag.array[i];
            lastUsedIndex++;
        }
        this.array = temp;
    }

    public void removeAll(int value){
        int[] temp = new int[493];
        int fin = lastUsedIndex + 2;
        lastUsedIndex = -1;
        for(int i = 0; i < fin; i++){
            if(array[i] != value){
                temp[++lastUsedIndex] = array[i];
            }
        }
        array = temp;
    }

    public int numOccurrences(int value){
        int count = 0;
        for(int i = 0; i < this.size(); i++){
            if(this.array[i] == value) count++;
        }
        return count;
    }

    public void ensureCapacity(int thisMany) {
        if (array.length - lastUsedIndex <= thisMany) {
            int[] temp = new int[array.length + (int)(thisMany * 1.25) + 5];
            System.arraycopy(array, 0, temp, 0, lastUsedIndex + 1);
            array = temp;
        }
    }

    public void add(int value) {
        ensureCapacity(1);
        array[++lastUsedIndex] = value;
    }

    /**
     * Removes a random value from the bag.  Why?  Because life should have some excitment!
     */
    public int pull() throws EmptyBagException {
        if (lastUsedIndex >= 0) {
            int randomIndex = random.nextInt(lastUsedIndex + 1);
            int value = array[randomIndex];
            array[randomIndex] = array[lastUsedIndex--];
            return value;
        }

        throw new EmptyBagException("No integer for you! You come back, one year!");
    }

    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    public boolean remove(int value) {
        int index = indexOf(value);
        if(index >= 0) {
            array[index] = array[lastUsedIndex--];
            return true;
        }
        return false;
    }

    private int indexOf(int value) {
        for (int i = 0; i <= lastUsedIndex; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        lastUsedIndex = -1;
    }

    public int size() {
        return lastUsedIndex + 1;
    }

    public void print() {
        for (int i = 0; i < lastUsedIndex; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[lastUsedIndex]);
    }
}