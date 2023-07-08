package algorithms.searches;

import algorithms.searches.LinearSearch;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class LinearSearchTest {

    /**
     * Tests the linearSearch method when the target element is found in the array.
     */
    @Test
    void testLinearSearch_ElementFound() {
        int[] arr = {5, 9, 3, 7, 2};
        int target = 7;
        int expectedIndex = 3;

        int actualIndex = LinearSearch.linearSearch(arr, target);

        Assertions.assertEquals(expectedIndex, actualIndex);
    }

    /**
     * Tests the linearSearch method when the target element is not found in the array.
     */
    @Test
    void testLinearSearch_ElementNotFound() {
        int[] arr = {5, 9, 3, 7, 2};
        int target = 10;
        int expectedIndex = -1;

        int actualIndex = LinearSearch.linearSearch(arr, target);

        Assertions.assertEquals(expectedIndex, actualIndex);
    }
}
