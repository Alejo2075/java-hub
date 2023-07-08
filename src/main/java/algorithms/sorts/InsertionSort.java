package algorithms.sorts;

class InsertionSort{

    /**
     * Sorts the given array using the insertion sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];  // Current element to be inserted in the sorted portion
            int j = i - 1;  // Index of the last element in the sorted portion

            // Find the correct position for key in the sorted portion
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // Shift elements to the right
                j -= 1;  // Move to the previous element
            }

            arr[j + 1] = key;  // Insert key in the correct position
        }
    }
}