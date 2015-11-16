package com.nester.helpers;

import com.nester.structures.*;

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

    /**
     * Create directed graph with components for testing purposes
     *
     * @return Directed graph with components
     */
    public static DirectedGraph createTestDirectedGraphWithComponents() {
        DirectedGraph graph = new DirectedGraph(13);

        graph.addEdge(0, 1);
        graph.addEdge(0, 5);

        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        graph.addEdge(3, 2);
        graph.addEdge(3, 5);

        graph.addEdge(4, 2);
        graph.addEdge(4, 3);

        graph.addEdge(5, 4);

        graph.addEdge(6, 0);
        graph.addEdge(6, 4);
        graph.addEdge(6, 8);
        graph.addEdge(6, 9);

        graph.addEdge(7, 6);
        graph.addEdge(7, 9);

        graph.addEdge(8, 6);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);

        graph.addEdge(10, 12);

        graph.addEdge(11, 12);

        graph.addEdge(12, 9);

        return graph;
    }

    /**
     * Creates edge-weighted graph for testing purposes
     *
     * @return Edge-weighted graph
     */
    public static EdgeWeightedGraph createTestEdgeWeightedGraph() {

        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
        graph.addEdge(new Edge(1, 2, 0.36));
        graph.addEdge(new Edge(4, 7, 0.37));
        graph.addEdge(new Edge(0, 4, 0.38));
        graph.addEdge(new Edge(6, 2, 0.40));
        graph.addEdge(new Edge(2, 7, 0.34));
        graph.addEdge(new Edge(4, 5, 0.35));
        graph.addEdge(new Edge(6, 0, 0.58));
        graph.addEdge(new Edge(3, 6, 0.52));
        graph.addEdge(new Edge(0, 7, 0.16));
        graph.addEdge(new Edge(5, 7, 0.28));
        graph.addEdge(new Edge(1, 3, 0.29));
        graph.addEdge(new Edge(1, 5, 0.32));
        graph.addEdge(new Edge(2, 3, 0.17));
        graph.addEdge(new Edge(1, 7, 0.19));
        graph.addEdge(new Edge(0, 2, 0.26));
        graph.addEdge(new Edge(6, 4, 0.93));

        return graph;
    }

    /**
     * Creates directed edge-weighted graph for testing purposes
     *
     * @return Directed edge-weighted graph
     */
    public static DirectedEdgeWeightedGraph createTestDirectedEdgeWeightedGraph() {

        DirectedEdgeWeightedGraph graph = new DirectedEdgeWeightedGraph(8);
        graph.addEdge(new DirectedEdge(0, 1, 5.0));
        graph.addEdge(new DirectedEdge(0, 4, 9.0));
        graph.addEdge(new DirectedEdge(0, 7, 8.0));

        graph.addEdge(new DirectedEdge(1, 2, 12.0));
        graph.addEdge(new DirectedEdge(1, 3, 15.0));
        graph.addEdge(new DirectedEdge(1, 7, 4.0));

        graph.addEdge(new DirectedEdge(2, 3, 3.0));
        graph.addEdge(new DirectedEdge(2, 6, 11.0));

        graph.addEdge(new DirectedEdge(3, 6, 9.0));

        graph.addEdge(new DirectedEdge(4, 5, 4.0));
        graph.addEdge(new DirectedEdge(4, 6, 20.0));
        graph.addEdge(new DirectedEdge(4, 7, 5.0));

        graph.addEdge(new DirectedEdge(5, 2, 1.0));
        graph.addEdge(new DirectedEdge(5, 6, 13.0));

        graph.addEdge(new DirectedEdge(7, 5, 6.0));
        graph.addEdge(new DirectedEdge(7, 2, 7.0));

        return graph;
    }

    public static DirectedEdgeWeightedGraph createTestDirectedCycledEdgeWeightedGraph() {
        DirectedEdgeWeightedGraph graph = new DirectedEdgeWeightedGraph(8);
        graph.addEdge(new DirectedEdge(4, 5, 0.35));
        graph.addEdge(new DirectedEdge(7, 4, 0.37));
        graph.addEdge(new DirectedEdge(5, 7, 0.28));
        graph.addEdge(new DirectedEdge(5, 1, 0.32));
        graph.addEdge(new DirectedEdge(0, 4, 0.38));
        graph.addEdge(new DirectedEdge(0, 2, 0.26));
        graph.addEdge(new DirectedEdge(7, 3, 0.39));
        graph.addEdge(new DirectedEdge(1, 3, 0.39));
        graph.addEdge(new DirectedEdge(2, 7, 0.34));
        graph.addEdge(new DirectedEdge(6, 2, 0.40));
        graph.addEdge(new DirectedEdge(6, 3, 0.52));
        graph.addEdge(new DirectedEdge(6, 0, 0.58));
        graph.addEdge(new DirectedEdge(6, 4, 0.93));

        return graph;
    }

    public static DirectedEdgeWeightedGraph createTestDirectedNegativeCycledEdgeWeightedGraph() {
        DirectedEdgeWeightedGraph graph = new DirectedEdgeWeightedGraph(8);
        graph.addEdge(new DirectedEdge(4, 5, 0.35));
        graph.addEdge(new DirectedEdge(5, 4, -0.66));
        graph.addEdge(new DirectedEdge(4, 7, 0.37));
        graph.addEdge(new DirectedEdge(5, 7, 0.28));
        graph.addEdge(new DirectedEdge(7, 5, 0.28));
        graph.addEdge(new DirectedEdge(5, 1, 0.32));
        graph.addEdge(new DirectedEdge(0, 4, 0.38));
        graph.addEdge(new DirectedEdge(0, 2, 0.26));
        graph.addEdge(new DirectedEdge(7, 3, 0.39));
        graph.addEdge(new DirectedEdge(1, 3, 0.39));
        graph.addEdge(new DirectedEdge(2, 7, 0.34));
        graph.addEdge(new DirectedEdge(6, 2, 0.40));
        graph.addEdge(new DirectedEdge(3, 6, 0.52));
        graph.addEdge(new DirectedEdge(6, 0, 0.58));
        graph.addEdge(new DirectedEdge(6, 4, 0.93));

        return graph;
    }

}
