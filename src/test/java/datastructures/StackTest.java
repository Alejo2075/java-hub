package datastructures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Unit tests for the Stack class.
 */
public class StackTest {
    private Stack stack = new Stack();

    /**
     * Tests the isEmpty method.
     */
    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(stack.isEmpty());

        stack.push(10);

        Assertions.assertFalse(stack.isEmpty());
    }

    /**
     * Tests the size method.
     */
    @Test
    public void testSize() {
        Assertions.assertEquals(0, stack.size());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        Assertions.assertEquals(3, stack.size());
    }

    /**
     * Test the push and pop methods.
     */
    @Test
    public void testPushPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        Assertions.assertEquals(30, stack.pop());
        Assertions.assertEquals(20, stack.pop());
        Assertions.assertEquals(10, stack.pop());
    }

    /**
     * Test the peek method.
     */
    @Test
    public void testPeek() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        int peekedElement = stack.peek();

        Assertions.assertEquals(3, stack.size());
        Assertions.assertEquals(30, peekedElement);
    }
}