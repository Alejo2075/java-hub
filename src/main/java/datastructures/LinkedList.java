package datastructures;

/**
 * Implementation of a LinkedList data structure that stores integer values.
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Inner class representing a Node.
     */
    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Constructs an empty LinkedList.
     */
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Checks if the LinkedList is empty.
     *
     * @return true if the LinkedList is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the LinkedList.
     *
     * @return the size of the LinkedList
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element to the end of the LinkedList.
     *
     * @param data the data to be added
     */
    public void add(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    /**
     * Adds an element at the specified position in the LinkedList.
     *
     * @param data     the data to be added
     * @param position the position at which the data should be inserted
     * @throws IndexOutOfBoundsException if the position is invalid (less than 0 or greater than size)
     */
    public void addAt(int data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        if (position == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;

            if (tail == null) {
                tail = newNode;
            }
        } else if (position == size) {
            add(data);
        } else {
            Node newNode = new Node(data);
            Node prev = getNode(position - 1);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }
    }

    /**
     * Change an element at the specified position for other in the LinkedList.
     *
     * @param data     the data to be added
     * @param position the position at which the data should be inserted
     * @throws IndexOutOfBoundsException if the position is invalid (less than 0 or greater than size)
     */
    public void change(int data, int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node node = getNode(position);
        node.data = data;
    }

    /**
     * Removes and returns the first element from the LinkedList.
     *
     * @return the removed element
     * @throws IllegalStateException if the LinkedList is empty
     */
    public int remove() {
        return removeAt(0);
    }

    /**
     * Removes and returns the element at the specified position in the LinkedList.
     *
     * @param position the position of the element to be removed
     * @return the removed element
     * @throws IndexOutOfBoundsException if the position is invalid (less than 0 or greater than or equal to size)
     */
    public int removeAt(int position) {
        if (isEmpty() || position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        int data;

        if (position == 0) {
            data = head.data;
            head = head.next;

            if (head == null) {
                tail = null;
            }
        } else {
            Node prev = getNode(position - 1);
            Node curr = prev.next;
            data = curr.data;
            prev.next = curr.next;

            if (curr == tail) {
                tail = prev;
            }
        }

        size--;
        return data;
    }

    /**
     * Returns the node at the specified position in the LinkedList.
     *
     * @param position the position of the node
     * @return the node at the specified position
     * @throws IndexOutOfBoundsException if the position is invalid (less than 0 or greater than or equal to size)
     */
    public int get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Returns the node at the specified position in the LinkedList.
     *
     * @param position the position of the node
     * @return the node at the specified position
     * @throws IndexOutOfBoundsException if the position is invalid (less than 0 or greater than or equal to size)
     */
    private Node getNode(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        return current;
    }
}