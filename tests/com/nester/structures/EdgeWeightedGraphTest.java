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

    @Test
    public void testGetEdges() {
        EdgeWeightedGraph graph = GraphHelper.createTestEdgeWeightedGraph();
        Iterable<Edge> edges = graph.getEdges();

        ArrayList<Double> edgeWeights = new ArrayList<>();
        for (Edge e : edges) {
            edgeWeights.add(e.weight());
        }

        assertEquals(16, edgeWeights.size());
        assertEquals("[0.38, 0.58, 0.16, 0.26, 0.36, 0.29, 0.32, 0.19, 0.4, 0.34, 0.17, 0.52, 0.37, 0.35, 0.93, 0.28]", edgeWeights.toString());
    }
}