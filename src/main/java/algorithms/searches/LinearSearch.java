package algorithms.searches;

class LinearSearch {

    /**
     * Searches for a target element in an array using linear search.
     *
     * @param arr    The array to search in.
     * @param target The element to search for.
     * @return The index of the target element if found, otherwise -1.
     */
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Element found, return its index
            }
        }
        return -1;  // Element not found
    }
}
