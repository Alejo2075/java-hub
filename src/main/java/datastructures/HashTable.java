package datastructures;

/**
 * Implementation of a Hash Table data structure in java
 */
public class HashTable {
    private static final int INITIAL_CAPACITY = 16;
    private Node[] table;
    private int size;

    /**
     * Node represents a key-value pair stored in the HashTable.
     */
    private class Node {
        private int key;
        private int value;
        private Node next;

        /**
         * Creates a new Node with the specified key and value.
         *
         * @param key   The key associated with the Node.
         * @param value The value associated with the Node.
         */
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Constructs an empty HashTable with the initial capacity.
     */
    public HashTable() {
        table = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Checks if the HashTable is empty.
     *
     * @return true if the HashTable is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of key-value pairs stored in the HashTable.
     *
     * @return The size of the HashTable.
     */
    public int size() {
        return size;
    }

    /**
     * Calculates the index in the table array for the given key using hashing.
     *
     * @param key The key for which the index needs to be calculated.
     * @return The index for the key in the table array.
     */
    private int getIndex(int key) {
        int hash = Integer.hashCode(key);
        return Math.abs(hash) % table.length;
    }

    /**
     * Inserts a key-value pair into the HashTable. If the key already exists, the value is updated.
     *
     * @param key   The key of the key-value pair.
     * @param value The value of the key-value pair.
     */
    public void put(int key, int value) {
        int index = getIndex(key);

        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current.next != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key == key) {
                current.value = value;
                return;
            }
            current.next = newNode;
        }

        size++;
    }

    /**
     * Retrieves the value associated with the given key from the HashTable.
     *
     * @param key The key for which the value needs to be retrieved.
     * @return The value associated with the key, or null if the key is not found.
     */
    public Integer get(int key) {
        int index = getIndex(key);

        Node current = table[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    /**
     * Removes the key-value pair with the specified key from the HashTable.
     *
     * @param key The key of the key-value pair to be removed.
     */
    public void remove(int key) {
        int index = getIndex(key);

        Node current = table[index];
        Node prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}