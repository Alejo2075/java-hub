package datastructures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Unit tests for the Heap class.
 */
public class HeapTest {
    private Heap heap = new Heap();


    /**
     * Tests the isEmpty method of the Heap class.
     */
    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(heap.isEmpty());
        heap.insert(5);
        Assertions.assertFalse(heap.isEmpty());
    }

    /**
     * Tests the size method of the Heap class.
     */
    @Test
    public void testSize() {
        Assertions.assertEquals(0, heap.size());
        heap.insert(10);
        heap.insert(5);
        Assertions.assertEquals(2, heap.size());
    }

    /**
     * Tests the insert method of the Heap class.
     */
    @Test
    public void testInsert() {
        heap.insert(10);
        heap.insert(5);
        heap.insert(7);
        Assertions.assertEquals(3, heap.size());
        Assertions.assertEquals(5, heap.peek());
    }

    /**
     * Tests the extractMin method of the Heap class.
     */
    @Test
    public void testExtractMin() {
        heap.insert(10);
        heap.insert(5);
        heap.insert(7);
        Assertions.assertEquals(5, heap.extractMin());
        Assertions.assertEquals(2, heap.size());
        Assertions.assertEquals(7, heap.peek());
    }

    /**
     * Tests the peek method of the Heap class.
     */
    @Test
    public void testPeek() {
        heap.insert(10);
        heap.insert(5);
        heap.insert(7);
        Assertions.assertEquals(5, heap.peek());
        Assertions.assertEquals(3, heap.size());
    }

    /**
     * Tests extracting minimum elements from an empty heap.
     */
    @Test
    public void testExtractMinEmptyHeap() {
        Assertions.assertThrows(IllegalStateException.class, () -> heap.extractMin());
    }

    /**
     * Tests peeking into an empty heap.
     */
    @Test
    public void testPeekEmptyHeap() {
        Assertions.assertThrows(IllegalStateException.class, () -> heap.peek());
    }
}