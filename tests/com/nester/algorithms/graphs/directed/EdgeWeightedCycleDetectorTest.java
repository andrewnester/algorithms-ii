package com.nester.algorithms.graphs.directed;

import com.nester.helpers.GraphHelper;
import com.nester.structures.DirectedEdge;
import com.nester.structures.DirectedEdgeWeightedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EdgeWeightedCycleDetectorTest {

    @Test
    public void testHasCycle() throws Exception {
        DirectedEdgeWeightedGraph graph = GraphHelper.createTestDirectedNegativeCycledEdgeWeightedGraph();
        EdgeWeightedCycleDetector detector = new EdgeWeightedCycleDetector(graph);
        assertTrue(detector.hasCycle());

        graph = GraphHelper.createTestDirectedCycledEdgeWeightedGraph();
        detector = new EdgeWeightedCycleDetector(graph);
        assertTrue(detector.hasCycle());

        graph = GraphHelper.createTestDirectedEdgeWeightedGraph();
        detector = new EdgeWeightedCycleDetector(graph);
        assertFalse(detector.hasCycle());

    }

    @Test
    public void testCycle() throws Exception {

        DirectedEdgeWeightedGraph graph = GraphHelper.createTestDirectedCycledEdgeWeightedGraph();
        EdgeWeightedCycleDetector detector = new EdgeWeightedCycleDetector(graph);

        Iterable<DirectedEdge> edges = detector.cycle();
        ArrayList<Double> weights = new ArrayList<>();
        for(DirectedEdge edge: edges) {
            weights.add(edge.weight());
        }

        Assert.assertEquals("[0.37, 0.28, 0.35]", weights.toString());

    }
}