package datastructures;

import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

/**
 * Tests for the HashTable class.
 */
public class HashTableTest {
    private HashTable hashTable = new HashTable();

    /**
     * Test for put() and get() methods.
     * Adds a key-value pair to the HashTable and verifies if the value can be retrieved correctly.
     */
    @Test
    public void testPutAndGet() {
        hashTable.put(1, 10);
        hashTable.put(2, 20);
        hashTable.put(3, 30);

        Assertions.assertEquals(10, (int) hashTable.get(1));
        Assertions.assertEquals(20, (int) hashTable.get(2));
        Assertions.assertEquals(30, (int) hashTable.get(3));
    }

    /**
     * Test for put() method with an existing key.
     * Adds a key-value pair to the HashTable with an existing key and verifies if the value is updated.
     */
    @Test
    public void testPutWithExistingKey() {
        hashTable.put(1, 10);
        hashTable.put(2, 20);
        hashTable.put(1, 30);

        Assertions.assertEquals(30, (int) hashTable.get(1));
        Assertions.assertEquals(20, (int) hashTable.get(2));
    }

    /**
     * Test for remove() method.
     * Adds key-value pairs to the HashTable and removes a key, then verifies if the key is successfully removed.
     */
    @Test
    public void testRemove() {
        hashTable.put(1, 10);
        hashTable.put(2, 20);
        hashTable.put(3, 30);

        hashTable.remove(2);

        Assertions.assertEquals(10, (int) hashTable.get(1));
        Assertions.assertNull(hashTable.get(2));
        Assertions.assertEquals(30, (int) hashTable.get(3));
    }

    /**
     * Test for size() method.
     * Adds key-value pairs to the HashTable and verifies if the size is calculated correctly.
     */
    @Test
    public void testSize() {
        Assertions.assertEquals(0, hashTable.size());

        hashTable.put(1, 10);
        hashTable.put(2, 20);

        Assertions.assertEquals(2, hashTable.size());

        hashTable.put(3, 30);
        hashTable.remove(1);

        Assertions.assertEquals(2, hashTable.size());
    }
}
