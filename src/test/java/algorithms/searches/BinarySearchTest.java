package algorithms.searches;


import algorithms.searches.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    /**
     * Tests that the binary search algorithm finds the element when it is present in the array.
     */
    @Test
    void TestBinarySearch_ElementFound(){
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;

        int result = BinarySearch.binarySearch(arr, target);

        Assertions.assertEquals(5, result);
    }

    /**
     * Tests that the binary search algorithm returns -1 when the element is not present in the array.
     */
    @Test
    void testBinarySearch_ElementNotFound(){
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 30;

        int result = BinarySearch.binarySearch(arr, target);

        Assertions.assertEquals(-1, result);
    }

}