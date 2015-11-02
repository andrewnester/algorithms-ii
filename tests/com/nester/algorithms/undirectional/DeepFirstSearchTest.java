package com.nester.algorithms.undirectional;

import com.nester.algorithms.structures.Graph;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class DeepFirstSearchTest {

    @Test
    public void hasPathTo() {
        Graph graph = createTestGraph();

        DeepFirstSearch dfs = new DeepFirstSearch(graph, 0);
        Assert.assertTrue("Vertex 0 must have path to vertex 1", dfs.hasPathTo(1));
        Assert.assertTrue("Vertex 0 must have path to vertex 3", dfs.hasPathTo(3));
        Assert.assertTrue("Vertex 0 must have path to vertex 4", dfs.hasPathTo(4));

        Assert.assertFalse("Vertex 0 must not have path to vertex 2", dfs.hasPathTo(2));

    }

    @Test
    public void pathTo() {
        Graph graph = createTestGraph();

        DeepFirstSearch dfs = new DeepFirstSearch(graph, 0);
        Iterable<Integer> path = dfs.pathTo(4);

        List<Integer> vertexes = new ArrayList<>();
        for(Integer vertex: path) {
            vertexes.add(vertex);
        }

        Assert.assertEquals("Wrong path to vertex 4 from 0", 3, vertexes.size());
        Assert.assertTrue("Wrong path to vertex 4 from 0", vertexes.contains(4));
        Assert.assertTrue("Wrong path to vertex 4 from 0", vertexes.contains(3));
        Assert.assertTrue("Wrong path to vertex 4 from 0", vertexes.contains(0));
    }

    private Graph createTestGraph() {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);

        return graph;
    }
}
