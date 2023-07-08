package datastructures;

/**
 * Implementation of a Queue data structure in Java using integers.
 */
public class Queue {
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
     * Constructs an empty Queue.
     */
    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Checks if the Queue is empty.
     *
     * @return true if the Queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of the Queue.
     *
     * @return the number of elements in the Queue.
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element to the end of the Queue.
     *
     * @param data the element to be added to the Queue.
     */
    public void enqueue(int data) {
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
     * Removes and returns the element at the front of the Queue.
     *
     * @return the element at the front of the Queue.
     * @throws IllegalStateException if the Queue is empty.
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("The Queue is empty");
        }

        int data = head.data;
        head = head.next;
        size--;

        if (isEmpty()) {
            tail = null;
        }

        return data;
    }

    /**
     * Returns the element at the front of the Queue without removing it.
     *
     * @return the element at the front of the Queue.
     * @throws IllegalStateException if the Queue is empty.
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }

        return head.data;
    }
}