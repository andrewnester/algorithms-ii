package com.nester.algorithms.undirectional;

import com.nester.algorithms.structures.Graph;
import org.junit.Assert;
import org.junit.Test;


public abstract class AbstractGraphSearchTest {

    protected abstract GraphSearchInterface getAlgorithm(Graph graph, int source);

    @Test
    public void hasPathTo() {
        Graph graph = createTestGraph();

        GraphSearchInterface dfs = getAlgorithm(graph, 0);
        Assert.assertTrue("Vertex 0 must have path to vertex 1", dfs.hasPathTo(1));
        Assert.assertTrue("Vertex 0 must have path to vertex 2", dfs.hasPathTo(2));
        Assert.assertTrue("Vertex 0 must have path to vertex 3", dfs.hasPathTo(3));
        Assert.assertTrue("Vertex 0 must have path to vertex 4", dfs.hasPathTo(4));
        Assert.assertTrue("Vertex 0 must have path to vertex 5", dfs.hasPathTo(5));
        Assert.assertTrue("Vertex 0 must have path to vertex 5", dfs.hasPathTo(6));

        Assert.assertFalse("Vertex 0 must not have path to vertex 7", dfs.hasPathTo(7));

    }

    @Test
    public void pathToNonConnectedVertex() {
        Graph graph = createTestGraph();

        GraphSearchInterface dfs = getAlgorithm(graph, 0);
        Assert.assertNull("Vertex 0 must not have path to vertex 7", dfs.pathTo(7));
    }

    protected Graph createTestGraph() {
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
}
