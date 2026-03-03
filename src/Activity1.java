public class Activity1 extends IntegerManager implements PrintPretty {
    public static void main(String[] args) throws Exception {
        Activity1 bibbityboppity = new Activity1();
        bibbityboppity.buildList();
        bibbityboppity.printPretty();
        bibbityboppity.shuffle();
        bibbityboppity.printPretty();
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

    @Override
    void insertionSort() {

    }

    @Override
    void selectionSort() {
    
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
