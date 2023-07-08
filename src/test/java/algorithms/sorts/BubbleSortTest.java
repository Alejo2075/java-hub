package algorithms.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BubbleSortTest{

    /**
     * Tests the bubbleSort method of the BubbleSort class.
     */
    @Test
    public void TestBubbleSort() {
        int[] input = {5, 2, 8, 12, 1};
        int[] expectedOutput = {1, 2, 5, 8, 12};

        BubbleSort.bubbleSort(input);

        Assertions.assertArrayEquals(expectedOutput, input);
    }

}