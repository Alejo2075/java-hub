package algorithms.searches;

class BinarySearch{

    /**
     * Performs binary search on a sorted array to find the target element.
     *
     * @param arr    The sorted array to search in.
     * @param target The element to search for.
     * @return The index of the target element if found, or -1 if not found.
     */
    static int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] < target){
                low = mid +1;  // Target element is in the right half of the subarray
            } else if (arr[mid] > target) {
                high = mid - 1; // Target element is in the left half of the subarray
            } else {
                return mid;  // Target element found at index mid
            }
        }

        return -1;  // Target element not found in the array
    }

}