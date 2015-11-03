package com.nester.helpers;

import com.nester.structures.DirectedGraph;
import com.nester.structures.Graph;

/**
 * Class GraphHelper
 * Helps to generate graphs for test purposes
 */
public class GraphHelper {

    /**
     * Generate simple test graph
     *
     * @return Test graph
     */
    public static Graph createTestGraph() {
        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 3);
        graph.addEdge(4, 6);

        return graph;
    }

    /**
     * Generate simple directed graph for test purpose
     *
     * @return Directed graph
     */
    public static DirectedGraph createTestDirectedGraph() {
        DirectedGraph graph = new DirectedGraph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 6);
        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        graph.addEdge(4, 6);

        graph.addEdge(2, 0);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 7);
        graph.addEdge(7, 0);
        return graph;
    }

    /**
     * Generate cycled directed graph for test purpose
     *
     * @return Cycled directed graph
     */
    public static DirectedGraph createTestCycledDirectedGraph() {
        DirectedGraph graph = new DirectedGraph(8);

        graph.addEdge(0, 7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 6);
        graph.addEdge(1, 5);
        graph.addEdge(4, 3);
        graph.addEdge(5, 2);
        graph.addEdge(2, 0);
        graph.addEdge(4, 6);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 7);

        return graph;
    }

}
