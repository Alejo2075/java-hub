package datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the LinkedList class.
 */
public class LinkedListTest {

    private LinkedList list = new LinkedList();

    /**
     * Tests the isEmpty() method of the LinkedList class.
     */
    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(list.isEmpty());

        list.add(10);
        Assertions.assertFalse(list.isEmpty());
    }

    /**
     * Tests the size() method of the LinkedList class.
     */
    @Test
    public void testSize() {
        Assertions.assertEquals(0, list.size());

        list.add(10);
        list.add(20);
        list.add(30);

        Assertions.assertEquals(3, list.size());
    }

    /**
     * Tests the add() method of the LinkedList class.
     */
    @Test
    public void testAdd() {
        list.add(10);
        list.add(20);
        list.add(30);

        Assertions.assertEquals(10, list.get(0));
        Assertions.assertEquals(20, list.get(1));
        Assertions.assertEquals(30, list.get(2));
    }

    /**
     * Tests the addAt() method of the LinkedList class.
     */
    @Test
    public void testAddAt() {
        list.add(10);
        list.add(20);
        list.add(30);

        list.addAt(15, 1);
        list.addAt(25, 3);

        Assertions.assertEquals(10, list.get(0));
        Assertions.assertEquals(15, list.get(1));
        Assertions.assertEquals(20, list.get(2));
        Assertions.assertEquals(25, list.get(3));
        Assertions.assertEquals(30, list.get(4));
    }

    /**
     * Tests the change() method of the LinkedList class.
     */
    @Test
    public void testChange(){
        list.add(10);
        list.add(20);
        list.add(30);

        list.change(0, 1);

        Assertions.assertEquals(0, list.get(1));
        Assertions.assertEquals(30, list.get(2));
    }

    /**
     * Tests the remove() method of the LinkedList class.
     */
    @Test
    public void testRemove() {
        list.add(10);
        list.add(20);
        list.add(30);

        int removedElement = list.remove();

        Assertions.assertEquals(10, removedElement);
        Assertions.assertEquals(20, list.get(0));
        Assertions.assertEquals(30, list.get(1));
        Assertions.assertEquals(2, list.size());
    }

    /**
     * Tests the removeAt() method of the LinkedList class.
     */
    @Test
    public void testRemoveAt() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        int removedElement = list.removeAt(2);

        Assertions.assertEquals(30, removedElement);
        Assertions.assertEquals(10, list.get(0));
        Assertions.assertEquals(20, list.get(1));
        Assertions.assertEquals(40, list.get(2));
        Assertions.assertEquals(3, list.size());
    }

    /**
     * Tests the get() method of the LinkedList class.
     */
    @Test
    public void testGet() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        Assertions.assertEquals(10, list.get(0));
        Assertions.assertEquals(20, list.get(1));
        Assertions.assertEquals(30, list.get(2));
        Assertions.assertEquals(40, list.get(3));
    }

    /**
     * Tests accessing an invalid position using the get() method of the LinkedList class.
     */
    @Test
    public void testInvalidGet() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));

        list.add(10);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    /**
     * Tests adding an element at an invalid position using the addAt() method of the LinkedList class.
     */
    @Test
    public void testInvalidAddAt() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.addAt(10, -1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.addAt(10, 1));
    }

    /**
     * Tests removing an element at an invalid position using the removeAt() method of the LinkedList class.
     */
    @Test
    public void testInvalidRemoveAt() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(0));

        list.add(10);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(1));
    }
}