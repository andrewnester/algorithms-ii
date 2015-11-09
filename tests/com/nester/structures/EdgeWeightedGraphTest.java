package com.nester.structures;

import com.nester.helpers.GraphHelper;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EdgeWeightedGraphTest {


    @Test
    public void testGetIncidentEdges() {

        EdgeWeightedGraph graph = GraphHelper.createTestEdgeWeightedGraph();
        Iterable<Edge> edges = graph.getIncidentEdges(0);

        ArrayList<Double> edgeWeights = new ArrayList<>();
        for (Edge e : edges) {
            edgeWeights.add(e.weight());
        }

        assertEquals("[0.38, 0.58, 0.16, 0.26]", edgeWeights.toString());

    }

    @Test
    public void testGetVertexCount() {
        EdgeWeightedGraph graph = GraphHelper.createTestEdgeWeightedGraph();
        assertEquals(8, graph.getVertexCount());
    }
}