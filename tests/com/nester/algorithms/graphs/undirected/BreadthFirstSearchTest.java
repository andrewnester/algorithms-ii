package com.nester.algorithms.graphs.undirected;

import com.nester.algorithms.graphs.undirected.helper.GraphHelper;
import com.nester.structures.Graph;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearchTest extends AbstractGraphSearchTest {

    @Override
    protected GraphSearchInterface getAlgorithm(Graph graph, int source) {
        return new BreadthFirstSearch(graph, source);
    }

    @Test
    public void pathTo() {
        Graph graph = GraphHelper.createTestGraph();

        GraphSearchInterface dfs = getAlgorithm(graph, 0);
        Iterable<Integer> path = dfs.pathTo(5);

        List<Integer> vertexes = new ArrayList<>();
        for (Integer vertex : path) {
            vertexes.add(vertex);
        }

        Assert.assertEquals("Wrong path to vertex 5 from 0", 2, vertexes.size());
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(5));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(0));
    }
}
