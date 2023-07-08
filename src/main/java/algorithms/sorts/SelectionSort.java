package algorithms.sorts;

class SelectionSort {

    /**
     * Sorts the given array using the selection sort algorithm.
     *
     * @param arr the array to be sorted
     */
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the unsorted part of the array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}