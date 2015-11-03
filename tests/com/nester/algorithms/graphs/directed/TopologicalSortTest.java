package com.nester.algorithms.graphs.directed;


import com.nester.helpers.GraphHelper;
import com.nester.structures.DirectedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSortTest {


    @Test
    public void topologicalSort() {
        DirectedGraph graph = GraphHelper.createTestDirectedGraph();
        TopologicalSort sorter = new TopologicalSort(graph);

        List<Integer> vertices = new ArrayList<>();
        for(int vertex : sorter.order()) {
            vertices.add(vertex);
        }

        Assert.assertTrue(sorter.isDAG());
        Assert.assertEquals("Wrong topological order", "[2, 7, 0, 4, 6, 3, 5, 1]", vertices.toString());

        graph = GraphHelper.createTestCycledDirectedGraph();
        sorter = new TopologicalSort(graph);


        Assert.assertFalse(sorter.isDAG());
        Assert.assertNull("Wrong topological order for non-DAG", sorter.order());
    }

}
