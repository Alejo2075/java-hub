package datastructures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * JUnit tests for the Set class.
 */
public class SetTest {
    private Set set = new Set();


    /**
     * Test the add method.
     */
    @Test
    public void testAdd() {
        set.add(1);
        set.add(2);
        set.add(3);

        Assertions.assertEquals(3, set.size());
        Assertions.assertTrue(set.contains(1));
        Assertions.assertTrue(set.contains(2));
        Assertions.assertTrue(set.contains(3));
    }

    /**
     * Test the remove method.
     */
    @Test
    public void testRemove() {
        set.add(1);
        set.add(2);
        set.add(3);

        set.remove(2);

        Assertions.assertEquals(2, set.size());
        Assertions.assertTrue(set.contains(1));
        Assertions.assertFalse(set.contains(2));
        Assertions.assertTrue(set.contains(3));
    }

    /**
     * Test the contains method.
     */
    @Test
    public void testContains() {
        set.add(1);
        set.add(2);

        Assertions.assertTrue(set.contains(1));
        Assertions.assertTrue(set.contains(2));
        Assertions.assertFalse(set.contains(3));
    }

    /**
     * Test the size method.
     */
    @Test
    public void testSize() {
        Assertions.assertEquals(0, set.size());

        set.add(1);
        set.add(2);

        Assertions.assertEquals(2, set.size());

        set.remove(1);

        Assertions.assertEquals(1, set.size());
    }

    /**
     * Test the isEmpty method.
     */
    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(set.isEmpty());

        set.add(1);

        Assertions.assertFalse(set.isEmpty());

        set.remove(1);

        Assertions.assertTrue(set.isEmpty());
    }

    /**
     * Test the clear method.
     */
    @Test
    public void testClear() {
        set.add(1);
        set.add(2);
        set.add(3);

        set.clear();

        Assertions.assertTrue(set.isEmpty());
        Assertions.assertEquals(0, set.size());
        Assertions.assertFalse(set.contains(1));
        Assertions.assertFalse(set.contains(2));
        Assertions.assertFalse(set.contains(3));
    }

    /**
     * Test the union method.
     */
    @Test
    public void testUnion() {
        Set otherSet = new Set();
        otherSet.add(2);
        otherSet.add(3);
        otherSet.add(4);

        set.add(1);
        set.add(2);
        set.add(3);

        Set resultSet = set.union(otherSet);

        Assertions.assertEquals(4, resultSet.size());
        Assertions.assertTrue(resultSet.contains(1));
        Assertions.assertTrue(resultSet.contains(2));
        Assertions.assertTrue(resultSet.contains(3));
        Assertions.assertTrue(resultSet.contains(4));
    }

    /**
     * Test the intersection method.
     */
    @Test
    public void testIntersection() {
        Set otherSet = new Set();
        otherSet.add(2);
        otherSet.add(3);
        otherSet.add(4);

        set.add(1);
        set.add(2);
        set.add(3);

        Set resultSet = set.intersection(otherSet);

        Assertions.assertEquals(2, resultSet.size());
        Assertions.assertTrue(resultSet.contains(2));
        Assertions.assertTrue(resultSet.contains(3));
        Assertions.assertFalse(resultSet.contains(1));
        Assertions.assertFalse(resultSet.contains(4));
    }

    /**
     * Test the difference method.
     */
    @Test
    public void testDifference() {
        Set otherSet = new Set();
        otherSet.add(2);
        otherSet.add(3);
        otherSet.add(4);

        set.add(1);
        set.add(2);
        set.add(3);

        Set resultSet = set.difference(otherSet);

        Assertions.assertEquals(1, resultSet.size());
        Assertions.assertTrue(resultSet.contains(1));
        Assertions.assertFalse(resultSet.contains(2));
        Assertions.assertFalse(resultSet.contains(3));
        Assertions.assertFalse(resultSet.contains(4));
    }
}
