package com.nester.algorithms.graphs.undirected;

import com.nester.algorithms.graphs.undirected.helper.GraphHelper;
import com.nester.structures.Graph;
import org.junit.Assert;
import org.junit.Test;


public abstract class AbstractGraphSearchTest {

    protected abstract GraphSearchInterface getAlgorithm(Graph graph, int source);

    @Test
    public void hasPathTo() {
        Graph graph = GraphHelper.createTestGraph();

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
        Graph graph = GraphHelper.createTestGraph();

        GraphSearchInterface dfs = getAlgorithm(graph, 0);
        Assert.assertNull("Vertex 0 must not have path to vertex 7", dfs.pathTo(7));
    }
}
