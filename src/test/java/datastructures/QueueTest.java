package datastructures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Unit tests for the Queue class.
 */
public class QueueTest {
    private Queue queue = new Queue();

    /**
     * Tests the isEmpty.
     */
    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(queue.isEmpty());

        queue.enqueue(10);
        Assertions.assertFalse(queue.isEmpty());
    }

    /**
     * Tests the size method.
     */
    @Test
    public void testSize() {
        Assertions.assertEquals(0, queue.size());

        queue.enqueue(10);
        queue.enqueue(20);
        Assertions.assertEquals(2, queue.size());

        queue.dequeue();
        Assertions.assertEquals(1, queue.size());
    }

    /**
     * Tests the enqueue and dequeue methods.
     */
    @Test
    public void testEnqueueAndDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        Assertions.assertEquals(10, queue.dequeue());
        Assertions.assertEquals(20, queue.dequeue());
        Assertions.assertEquals(30, queue.dequeue());
    }

    /**
     * Tests the peek method.
     */
    @Test
    public void testPeek() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        Assertions.assertEquals(10, queue.peek());
        Assertions.assertEquals(10, queue.peek());
    }
}