package datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the Graph class.
 */
public class GraphTest {
    private Graph graph;

    /**
     * Sets up the Graph object before each test method is executed.
     */
    @BeforeEach
    public void setup() {
        graph = new Graph();
    }

    /**
     * Tests the addNode method of the Graph class.
     */
    @Test
    public void testAddNode() {
        graph.addNode(1);
        graph.addNode(2);

        Assertions.assertEquals(2, graph.getSize());
    }

    /**
     * Tests the addEdge method of the Graph class.
     */
    @Test
    public void testAddEdge() {
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        Assertions.assertEquals(1, graph.getNode(1).getAdjacentNodes().size());
        Assertions.assertEquals(1, graph.getNode(2).getAdjacentNodes().size());
    }

    /**
     * Tests the removeNode method of the Graph class.
     */
    @Test
    public void testRemoveNode() {
        graph.addNode(1);
        graph.addNode(2);
        graph.addEdge(1, 2);

        Assertions.assertTrue(graph.removeNode(2));
        Assertions.assertNull(graph.getNode(2));
        Assertions.assertEquals(0, graph.getNode(1).getAdjacentNodes().size());
    }

    /**
     * Tests the removeEdge method of the Graph class.
     */
    @Test
    public void testRemoveEdge() {
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        Assertions.assertTrue(graph.removeEdge(1, 2));
        Assertions.assertEquals(0, graph.getNode(1).getAdjacentNodes().size());
        Assertions.assertEquals(1, graph.getNode(2).getAdjacentNodes().size());
    }

    /**
     * Tests the getSize method of the Graph class.
     */
    @Test
    public void testGetSize() {
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

        Assertions.assertEquals(3, graph.getSize());
    }

    /**
     * Tests the isEmpty method of the Graph class.
     */
    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(graph.isEmpty());

        graph.addNode(1);

        Assertions.assertFalse(graph.isEmpty());
    }
}