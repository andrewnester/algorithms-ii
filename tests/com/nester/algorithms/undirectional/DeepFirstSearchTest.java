package com.nester.algorithms.undirectional;

import com.nester.algorithms.structures.Graph;
import com.nester.algorithms.undirectional.helper.GraphHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DeepFirstSearchTest extends AbstractGraphSearchTest {

    @Override
    protected GraphSearchInterface getAlgorithm(Graph graph, int source) {
        return new DeepFirstSearch(graph, source);
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

        Assert.assertEquals("Wrong path to vertex 5 from 0", 4, vertexes.size());
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(6));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(5));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(4));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertexes.contains(0));
    }
}
