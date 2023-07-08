package algorithms.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SelectionSortTest {

    /**
     * Tests the selectionSort method with a regular array.
     */
    @Test
    public void testSelectionSort() {
        int[] array = {5, 2, 8, 12, 1, 9};
        int[] sortedArray = {1, 2, 5, 8, 9, 12};

        SelectionSort.selectionSort(array);

        Assertions.assertArrayEquals(sortedArray, array);
    }

    /**
     * Tests the selectionSort method with an empty array.
     */
    @Test
    public void testSelectionSortWithEmptyArray() {
        int[] array = {};
        int[] sortedArray = {};

        SelectionSort.selectionSort(array);

        Assertions.assertArrayEquals(sortedArray, array);
    }

    /**
     * Tests the selectionSort method with an array containing duplicate values.
     */
    @Test
    public void testSelectionSortWithDuplicateValues() {
        int[] array = {5, 2, 8, 12, 1, 9, 5, 1};
        int[] sortedArray = {1, 1, 2, 5, 5, 8, 9, 12};

        SelectionSort.selectionSort(array);

        Assertions.assertArrayEquals(sortedArray, array);
    }
}
