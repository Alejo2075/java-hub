package datastructures;

/**
 * This class implements a Stack data structure using integers.
 */
public class Stack {
    private Node top;
    private int size;

    /**
     * Inner class representing a Node.
     */
    private class Node {
        private int data; // Data stored in the node
        private Node next; // Reference to the next node in the stack

        /**
         * Constructs a new node with the given data.
         *
         * @param data the data to be stored in the node
         */
        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Constructs an empty stack.
     */
    public Stack() {
        top = null;
        size = 0;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    public int size() {
        return size;
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param data the element to be pushed onto the stack
     */
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty");
        }

        int data = top.data;
        top = top.next;
        size--;
        return data;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty");
        }

        return top.data;
    }
}