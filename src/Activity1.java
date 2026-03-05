public class Activity1 extends IntegerManager implements PrintPretty {
    public static void main(String[] args) throws Exception {
        Activity1 bippityboppity = new Activity1();
        bippityboppity.buildList();
        bippityboppity.printPretty();
        bippityboppity.shuffle();
        bippityboppity.printPretty();
        bippityboppity.selectionSort();;
        bippityboppity.printPretty();
        bippityboppity.shuffle();
        bippityboppity.printPretty();
        bippityboppity.selectionSort(true);;
        bippityboppity.printPretty();
    }

    @Override
    void buildList() {
        nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            // random numbers 1 - 100
            nums[i] = (int)(Math.random() * 100) + 1;
        }
    }

    @Override
    void shuffle() {
        // loop through all numbers and do a 3-part-swap
        for (int i = 0; i < nums.length; i++) {
            int randIndex = (int)(Math.random() * nums.length);
            int temp = nums[i];
            nums[i] = nums[randIndex];
            nums[randIndex] = temp;
        }
    }

    void selectionSort(boolean highToLow) {
        if (!highToLow) {
            selectionSort();
            return;
        }
        // outer loop  - iterate through n - 1
        for (int outer = 0; outer < nums.length - 1; outer++) {
            int largestIndex = outer;
            // inner loop - find largest index
            for (int inner = outer + 1; inner < nums.length; inner++) {
                if (nums[inner] > nums[largestIndex]) largestIndex = inner;
            }
            // 3-part swap
            int temp = nums[outer];
            nums[outer] = nums[largestIndex];
            nums[largestIndex] = temp;
        }
    }

    @Override
    void selectionSort() {
        // outer loop  - iterate through n - 1
        for (int outer = 0; outer < nums.length - 1; outer++) {
            int smallestIndex = outer;
            // inner loop - find smallest index
            for (int inner = outer + 1; inner < nums.length; inner++) {
                if (nums[inner] < nums[smallestIndex]) smallestIndex = inner;
            }
            // 3-part swap
            int temp = nums[outer];
            nums[outer] = nums[smallestIndex];
            nums[smallestIndex] = temp;
        }
    }
    
    @Override
    void insertionSort() {

    }

    @Override
    void mergeSort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mergeSort'");
    }

    @Override
    int pickRandom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pickRandom'");
    }

    @Override
    public void printPretty() {
        System.out.println("\n----- Printing array of size " + nums.length + ": -----");
        System.out.print("{");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.print("}");
    }
}
