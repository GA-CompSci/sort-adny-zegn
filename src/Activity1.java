public class Activity1 extends IntegerManager implements PrintPretty {
    public static void main(String[] args) throws Exception {
        Activity1 bibbityboppity = new Activity1();
        bibbityboppity.buildList();
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
        int temp;
    }

    @Override
    void insertionSort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertionSort'");
    }

    @Override
    void selectionSort() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectionSort'");
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
