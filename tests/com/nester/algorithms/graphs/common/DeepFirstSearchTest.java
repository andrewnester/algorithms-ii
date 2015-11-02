package com.nester.algorithms.graphs.common;

import com.nester.helpers.GraphHelper;
import com.nester.structures.Graph;
import com.nester.structures.GraphInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DeepFirstSearchTest  {

    @Test
    public void undirectedGraphPathTo() {
        GraphInterface graph = GraphHelper.createTestGraph();

        GraphSearchInterface dfs = getAlgorithm(graph, 0);
        Iterable<Integer> path = dfs.pathTo(5);

        List<Integer> vertexes = new ArrayList<>();
        for (Integer vertex : path) {
            vertexes.add(vertex);
        }

        Assert.assertEquals("Wrong path to vertex 5 from 0", 4, vertexes.size());
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(6));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(5));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(4));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(0));
    }

    @Test
    public void directedGraphPathTo() {
        GraphInterface graph = GraphHelper.createTestDirectedGraph();

        GraphSearchInterface dfs = getAlgorithm(graph, 0);
        Iterable<Integer> path = dfs.pathTo(5);

        List<Integer> vertexes = new ArrayList<>();
        for (Integer vertex : path) {
            vertexes.add(vertex);
        }

        Assert.assertEquals("Wrong path to vertex 5 from 0", 4, vertexes.size());
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(3));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(4));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(5));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(0));
    }

    @Test
    public void undirectedGraphHasPathTo() {
        Graph graph = GraphHelper.createTestGraph();

        GraphSearchInterface dfs = getAlgorithm(graph, 0);
        Assert.assertTrue("Vertex 0 must have path to vertex 1", dfs.hasPathTo(1));
        Assert.assertTrue("Vertex 0 must have path to vertex 2", dfs.hasPathTo(2));
        Assert.assertTrue("Vertex 0 must have path to vertex 3", dfs.hasPathTo(3));
        Assert.assertTrue("Vertex 0 must have path to vertex 4", dfs.hasPathTo(4));
        Assert.assertTrue("Vertex 0 must have path to vertex 5", dfs.hasPathTo(5));
        Assert.assertTrue("Vertex 0 must have path to vertex 6", dfs.hasPathTo(6));

        Assert.assertFalse("Vertex 0 must not have path to vertex 7", dfs.hasPathTo(7));

    }

    @Test
    public void directedGraphHasPathTo() {
        Graph graph = GraphHelper.createTestDirectedGraph();

        GraphSearchInterface dfs = getAlgorithm(graph, 0);
        Assert.assertTrue("Vertex 0 must have path to vertex 1", dfs.hasPathTo(1));
        Assert.assertTrue("Vertex 0 must have path to vertex 3", dfs.hasPathTo(3));
        Assert.assertTrue("Vertex 0 must have path to vertex 4", dfs.hasPathTo(4));
        Assert.assertTrue("Vertex 0 must have path to vertex 5", dfs.hasPathTo(5));
        Assert.assertTrue("Vertex 0 must have path to vertex 6", dfs.hasPathTo(6));

        Assert.assertFalse("Vertex 0 must not have path to vertex 2", dfs.hasPathTo(2));
        Assert.assertFalse("Vertex 0 must not have path to vertex 7", dfs.hasPathTo(7));

    }

    @Test
    public void pathToNonConnectedVertexUndirectedGraph() {
        GraphInterface graph = GraphHelper.createTestGraph();

        GraphSearchInterface dfs = getAlgorithm(graph, 0);
        Assert.assertNull("Vertex 0 must not have path to vertex 7", dfs.pathTo(7));
    }

    @Test
    public void pathToNonConnectedVertexDirectedGraph() {
        GraphInterface graph = GraphHelper.createTestDirectedGraph();

        GraphSearchInterface dfs = getAlgorithm(graph, 0);
        Assert.assertNull("Vertex 0 must not have path to vertex 2", dfs.pathTo(2));
        Assert.assertNull("Vertex 0 must not have path to vertex 7", dfs.pathTo(7));
    }

    private GraphSearchInterface getAlgorithm(GraphInterface graph, int source) {
        return new DeepFirstSearch(graph, source);
    }
}
