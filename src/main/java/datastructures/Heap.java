package datastructures;

/**
 * Implementation of a Heap data structure using a binary tree structure.
 */
public class Heap {
    private Node root;
    private int size;

    /**
     * Internal class representing a node in the binary tree.
     */
    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Constructs an empty Heap.
     */
    public Heap() {
        root = null;
        size = 0;
    }

    /**
     * Checks if the heap is empty.
     *
     * @return true if the heap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the heap.
     *
     * @return the size of the heap.
     */
    public int size() {
        return size;
    }

    /**
     * Inserts an element into the heap.
     *
     * @param data the element to insert.
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        size++;

        if (root == null) {
            root = newNode;
        } else {
            insertHelper(root, newNode);
        }
    }

    /**
     * Helper method to recursively insert a new node into the heap.
     *
     * @param currentNode the current node being checked.
     * @param newNode     the new node to be inserted.
     */
    private void insertHelper(Node currentNode, Node newNode) {
        if (currentNode.left == null) {
            currentNode.left = newNode;
        } else if (currentNode.right == null) {
            currentNode.right = newNode;
        } else {
            // Choose the subtree with fewer nodes
            if (size(currentNode.left) <= size(currentNode.right)) {
                insertHelper(currentNode.left, newNode);
            } else {
                insertHelper(currentNode.right, newNode);
            }
        }

        // Swap nodes if necessary to maintain the heap property
        if (newNode.data < currentNode.data) {
            swapValues(currentNode, newNode);
        }
    }

    /**
     * Computes the number of nodes in the subtree rooted at the given node.
     *
     * @param node the root of the subtree.
     * @return the number of nodes in the subtree.
     */
    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    /**
     * Swaps the values of two nodes.
     *
     * @param node1 the first node.
     * @param node2 the second node.
     */
    private void swapValues(Node node1, Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    /**
     * Removes and returns the minimum element from the heap.
     *
     * @return the minimum element in the heap.
     * @throws IllegalStateException if the heap is empty.
     */
    public int extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("The heap is empty");
        }

        int min = root.data;
        Node lastNode = findLastNode();
        if (lastNode != null) {
            root.data = lastNode.data;
            deleteLastNode();
            heapify(root);
        } else {
            root = null;
        }

        size--;
        return min;
    }

    /**
     * Finds the last node in the binary tree.
     *
     * @return the last node in the tree.
     */
    private Node findLastNode() {
        if (root == null) {
            return null;
        }

        String binaryString = Integer.toBinaryString(size);
        Node currentNode = root;
        for (int i = 1; i < binaryString.length(); i++) {
            char direction = binaryString.charAt(i);
            if (direction == '0') {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        return currentNode;
    }

    /**
     * Deletes the last node in the binary tree.
     */
    private void deleteLastNode() {
        if (root == null) {
            return;
        }

        String binaryString = Integer.toBinaryString(size);
        Node parentNode = null;
        Node currentNode = root;
        for (int i = 1; i < binaryString.length() - 1; i++) {
            char direction = binaryString.charAt(i);
            parentNode = currentNode;
            if (direction == '0') {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        if (parentNode != null) {
            if (binaryString.charAt(binaryString.length() - 1) == '0') {
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
        }
    }

    /**
     * Restores the heap property starting from the given node.
     *
     * @param currentNode the node to start the heapify process from.
     */
    private void heapify(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        Node smallest = currentNode;
        if (currentNode.left != null && currentNode.left.data < smallest.data) {
            smallest = currentNode.left;
        }
        if (currentNode.right != null && currentNode.right.data < smallest.data) {
            smallest = currentNode.right;
        }

        if (smallest != currentNode) {
            swapValues(currentNode, smallest);
            heapify(smallest);
        }
    }

    /**
     * Returns the minimum element in the heap without removing it.
     *
     * @return the minimum element in the heap.
     * @throws IllegalStateException if the heap is empty.
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The heap is empty");
        }

        return root.data;
    }
}
