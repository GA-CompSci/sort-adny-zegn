public class Activity1 extends IntegerManager implements PrintPretty {
    public static void main(String[] args) throws Exception {
        Activity1 bippityboppity = new Activity1();
        bippityboppity.buildList();
        bippityboppity.printPretty();
        bippityboppity.shuffle();
        bippityboppity.printPretty();
        // bippityboppity.selectionSort();
        // bippityboppity.selectionSort(true);
        // bippityboppity.insertionSort();
        // bippityboppity.insertionSort(true);
        bippityboppity.mergeSort(bippityboppity.nums);
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
        // outer loop
        for (int outer = 1; outer < nums.length; outer++) {
            int inner = outer - 1;
            int temp = nums[outer];
            // inner while loop
            while (inner > -1 && nums[inner] > temp) {
                nums[inner + 1] = nums[inner];
                inner--;
            }
            nums[inner + 1] = temp;
            System.out.println("\nInsertion sort iteration number " + (outer - 1) + ":");
            printPretty();;
        }
    }

    void insertionSort(boolean highToLow) {
        if (!highToLow) {
            insertionSort();
            return;
        }
        // outer loop
        for (int outer = 1; outer < nums.length; outer++) {
            int inner = outer - 1;
            int temp = nums[outer];
            // inner while loop
            while (inner > -1 && nums[inner] < temp) {
                nums[inner + 1] = nums[inner];
                inner--;
            }
            nums[inner + 1] = temp;
        }
    }

    @Override
    void mergeSort(int[] nums) {
        // n = amount of items in list
        // base case:
        if (nums.length <= 1) return;
        //split
        int mid = nums.length / 2;
        int[] ell = new int[mid];
        int[] are = new int[nums.length - mid];
        for (int i = 0; i < mid; i++) {
            ell[i] = nums[i];
        }
        for (int i = mid; i < nums.length; i++) {
            are[i - mid] = nums[i];
        }
        mergeSort(ell);
        mergeSort(are);

        merge(nums, ell, are, mid, nums.length - mid);
    }

    void merge(int[] nums, int[] ell, int[] are, int left, int right) {
        // counters: i = left, j = right, k = nums
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (ell[i] <= are[j]) {
                nums[k++] = ell[i++];
            } else nums[k++] = are[j++];
        }

        // case: only left remaining
        while (i < left) {
            nums[k++] = ell[i++];
        }

        // case: only right remaining
        while (j < right) {
            nums[k++] = are[j++];
        }
    }

    @Override
    int pickRandom() {
        return (int)(Math.random() * nums.length);
    }

    int binarySearch(int what) {
        // track search window
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] == what) return middle;
            else if (nums[middle] > what) {
                high = middle - 1;
            } else if (nums[middle] < what) {
                low = middle + 1;
            }
        }
        return -1;
    }

    @Override
    public void printPretty() {
        System.out.println("----- Printing array of size " + nums.length + ": -----");
        System.out.print("{");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("}");
    }
}
