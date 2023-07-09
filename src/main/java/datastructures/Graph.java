package datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * A Graph data structure implemented in Java using integers.
 */
public class Graph {
    private List<Node> nodes;
    private int size;

    public class Node {
        private int value;
        private List<Node> adjacentNodes;

        /**
         * Initializes a new node with the specified value.
         *
         * @param value the value of the node
         */
        public Node(int value) {
            this.value = value;
            adjacentNodes = new ArrayList<>();
        }

        /**
         * Get the adjecent nodes list
         *
         * @return the adjacent nodes list
         */
        public List<Node> getAdjacentNodes(){
            return adjacentNodes;
        }

        /**
         * Adds an adjacent node to the current node.
         *
         * @param node the adjacent node to add
         */
        public void addAdjacentNode(Node node) {
            adjacentNodes.add(node);
        }

        /**
         * Removes an adjacent node from the current node.
         *
         * @param node the adjacent node to remove
         * @return true if the node was successfully removed, false otherwise
         */
        public boolean removeAdjacentNode(Node node) {
            return adjacentNodes.remove(node);
        }
    }

    /**
     * Initializes an empty graph.
     */
    public Graph() {
        nodes = new ArrayList<>();
        size = 0;
    }

    /**
     * Checks if the graph is empty.
     *
     * @return true if the graph is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the number of nodes in the graph.
     *
     * @return the number of nodes in the graph
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds a new node to the graph.
     *
     * @param value the value of the node
     */
    public void addNode(int value) {
        Node newNode = new Node(value);
        nodes.add(newNode);
        size++;
    }

    /**
     * Removes a node from the graph.
     *
     * @param value the value of the node to remove
     * @return true if the node was successfully removed, false otherwise
     */
    public boolean removeNode(int value) {
        Node nodeToRemove = getNode(value);
        if (nodeToRemove != null) {
            nodes.remove(nodeToRemove);
            for (Node node : nodes) {
                node.removeAdjacentNode(nodeToRemove);
            }
            return true;
        }
        return false;
    }

    /**
     * Adds an edge between two nodes in the graph.
     *
     * @param source      the value of the source node
     * @param destination the value of the destination node
     */
    public void addEdge(int source, int destination) {
        Node sourceNode = getNode(source);
        Node destNode = getNode(destination);

        if (sourceNode != null && destNode != null) {
            sourceNode.addAdjacentNode(destNode);
        }
    }

    /**
     * Removes an edge between two nodes in the graph.
     *
     * @param source      the value of the source node
     * @param destination the value of the destination node
     * @return true if the edge was successfully removed, false otherwise
     */
    public boolean removeEdge(int source, int destination) {
        Node sourceNode = getNode(source);
        Node destNode = getNode(destination);

        if (sourceNode != null && destNode != null) {
            return sourceNode.removeAdjacentNode(destNode);
        }
        return false;
    }

    public Node getNode(int value) {
        for (Node node : nodes) {
            if (node.value == value) {
                return node;
            }
        }
        return null;
    }

}