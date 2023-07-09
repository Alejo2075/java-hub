package datastructures;

/**
 * Implementation of a Set data structure in Java.
 */
public class Set {
    private Node head;
    private int size;

    /**
     * Inner class representing a node in the linked list.
     */
    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Constructs an empty set.
     */
    public Set() {
        head = null;
        size = 0;
    }

    /**
     * Checks if the set is empty.
     *
     * @return true if the set is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the size of the set.
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element to the set if it's not already present.
     *
     * @param data the element to be added to the set.
     */
    public void add(int data) {
        if (contains(data)) {
            return;
        }

        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
    }

    /**
     * Removes an element from the set if it exists.
     *
     * @param data the element to be removed from the set.
     */
    public void remove(int data) {
        if (isEmpty()) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    /**
     * Checks if the set contains a given element.
     *
     * @param data the element to be checked.
     * @return true if the set contains the element, false otherwise.
     */
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Removes all elements from the set.
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Creates a new set that contains all the elements from the current set and another set.
     *
     * @param otherSet the set to be combined with the current set.
     * @return a new set representing the union of the two sets.
     */
    public Set union(Set otherSet) {
        Set resultSet = new Set();
        Node current = head;

        while (current != null) {
            resultSet.add(current.data);
            current = current.next;
        }

        current = otherSet.head;
        while (current != null) {
            resultSet.add(current.data);
            current = current.next;
        }

        return resultSet;
    }

    /**
     * Creates a new set that contains the common elements between the current set and another set.
     *
     * @param otherSet the set to be intersected with the current set.
     * @return a new set representing the intersection of the two sets.
     */
    public Set intersection(Set otherSet) {
        Set resultSet = new Set();
        Node current = head;

        while (current != null) {
            if (otherSet.contains(current.data)) {
                resultSet.add(current.data);
            }
            current = current.next;
        }

        return resultSet;
    }

    /**
     * Creates a new set that contains the elements present in the current set but not in another set.
     *
     * @param otherSet the set to be subtracted from the current set.
     * @return a new set representing the difference between the two sets.
     */
    public Set difference(Set otherSet) {
        Set resultSet = new Set();
        Node current = head;

        while (current != null) {
            if (!otherSet.contains(current.data)) {
                resultSet.add(current.data);
            }
            current = current.next;
        }

        return resultSet;
    }
}