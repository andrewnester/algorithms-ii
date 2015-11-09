package com.nester.structures;

import com.nester.helpers.GraphHelper;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DirectedEdgeWeightedGraphTest {

    @Test
    public void testGetIncidentEdges() {

        DirectedEdgeWeightedGraph graph = GraphHelper.createTestDirectedEdgeWeightedGraph();

        Iterable<DirectedEdge> edges = graph.getIncidentEdges(0);

        ArrayList<Double> edgeWeights = new ArrayList<>();
        for (DirectedEdge e : edges) {
            edgeWeights.add(e.weight());
        }

        assertEquals("[5.0, 9.0, 8.0]", edgeWeights.toString());

    }

    @Test
    public void testGetVertexCount() {

        DirectedEdgeWeightedGraph graph = GraphHelper.createTestDirectedEdgeWeightedGraph();

        assertEquals(8, graph.getVertexCount());
    }
}