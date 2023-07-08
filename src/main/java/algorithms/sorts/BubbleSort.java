package algorithms.sorts;

class BubbleSort{

    /**
     * Sorts an array of integers using the bubble sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    static void bubbleSort(int[] arr) {
        // Outer loop iterates from the beginning of the array to the second-to-last element
        for (int i = 0; i < arr.length - 1; i++) {
            // Inner loop iterates from the beginning of the array to the element before the last sorted element
            for (int j = 0; j < arr.length - i - 1; j++) {
                // Compare adjacent elements and swap if necessary to move the larger element towards the end
                if (arr[j] > arr[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}