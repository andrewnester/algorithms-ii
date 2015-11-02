package com.nester.algorithms.graphs.undirected.helper;

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
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        return graph;
    }

    public static DirectedGraph createTestDirectedGraph() {
        DirectedGraph graph = new DirectedGraph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        return graph;
    }

}
