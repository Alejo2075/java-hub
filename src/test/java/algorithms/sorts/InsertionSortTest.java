package algorithms.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionSortTest {

    /**
     * Test the insertion sort algorithm with a simple array.
     */
    @Test
    public void testInsertionSort() {
        int[] arr = {5, 3, 1, 4, 2};
        int[] sortedArr = {1, 2, 3, 4, 5};

        InsertionSort.insertionSort(arr);

        Assertions.assertArrayEquals(sortedArr, arr);
    }

    /**
     * Test the insertion sort algorithm with an empty array.
     */
    @Test
    public void testInsertionSortEmptyArray() {
        int[] arr = {};
        int[] sortedArr = {};

        InsertionSort.insertionSort(arr);

        Assertions.assertArrayEquals(sortedArr, arr);
    }

    /**
     * Test the insertion sort algorithm with a single element array.
     */
    @Test
    public void testInsertionSortSingleElementArray() {
        int[] arr = {5};
        int[] sortedArr = {5};

        InsertionSort.insertionSort(arr);

        Assertions.assertArrayEquals(sortedArr, arr);
    }
}
