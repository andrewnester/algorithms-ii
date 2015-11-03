package com.nester.algorithms.graphs.directed;


import com.nester.helpers.GraphHelper;
import com.nester.structures.DirectedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class DeepFirstOrderTest {

    @Test
    public void order() {
        DirectedGraph graph = GraphHelper.createTestDirectedGraph();
        DeepFirstOrder dfo = new DeepFirstOrder(graph);

        LinkedList<Integer> vertices = new LinkedList<>();
        for(int vertex: dfo.getPreOrder()) {
            vertices.add(vertex);
        }

        Assert.assertEquals("Wrong pre order length", graph.getVertexCount(), vertices.size());
        Assert.assertEquals("Wrong pre order", "[0, 6, 4, 3, 5, 1, 2, 7]", vertices.toString());

        vertices = new LinkedList<>();
        for(int vertex: dfo.getPostOrder()) {
            vertices.add(vertex);
        }

        Assert.assertEquals("Wrong post order length", graph.getVertexCount(), vertices.size());
        Assert.assertEquals("Wrong post order", "[6, 5, 3, 4, 1, 0, 7, 2]", vertices.toString());

        vertices = new LinkedList<>();
        for(int vertex: dfo.getReversePostOrder()) {
            vertices.add(vertex);
        }

        Assert.assertEquals("Wrong reverse post order length", graph.getVertexCount(), vertices.size());
        Assert.assertEquals("Wrong reverse post order", "[2, 7, 0, 1, 4, 3, 5, 6]", vertices.toString());

    }

}
