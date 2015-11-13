package com.nester.algorithms.graphs.directed;

import com.nester.helpers.GraphHelper;
import com.nester.structures.DirectedEdge;
import com.nester.structures.DirectedEdgeWeightedGraph;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DijkstraAlgorithmTest {

    @Test
    public void testDijkstraAlgorithm() {

        DirectedEdgeWeightedGraph graph = GraphHelper.createTestDirectedEdgeWeightedGraph();
        DijkstraAlgorithm da = new DijkstraAlgorithm(graph, 0);

        assertTrue(Double.compare(5.0, da.distTo(1)) == 0);
        assertTrue(Double.compare(14.0, da.distTo(2)) == 0);
        assertTrue(Double.compare(17.0, da.distTo(3)) == 0);
        assertTrue(Double.compare(9.0, da.distTo(4)) == 0);
        assertTrue(Double.compare(13.0, da.distTo(5)) == 0);
        assertTrue(Double.compare(25.0, da.distTo(6)) == 0);
        assertTrue(Double.compare(8.0, da.distTo(7)) == 0);

        Iterable<DirectedEdge> path = da.pathTo(3);
        ArrayList<Double> edgeWeights = new ArrayList<>();
        for (DirectedEdge e : path) {
            edgeWeights.add(e.weight());
        }

        assertEquals("[3.0, 1.0, 4.0, 9.0]", edgeWeights.toString());

    }

}