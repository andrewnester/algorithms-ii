package com.nester.algorithms.graphs.undirected;

import com.nester.helpers.GraphHelper;
import com.nester.structures.Edge;
import com.nester.structures.EdgeWeightedGraph;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LazyPrimAlgorithmTest {

    @Test
    public void testLazyPrimAlgorithm() throws Exception {
        EdgeWeightedGraph graph = GraphHelper.createTestEdgeWeightedGraph();

        LazyPrimAlgorithm lpa = new LazyPrimAlgorithm();

        lpa.run(graph);
        Iterable<Edge> edges = lpa.getEdges();

        ArrayList<Double> edgeWeights = new ArrayList<>();
        for (Edge e : edges) {
            edgeWeights.add(e.weight());
        }

        assertEquals(7, edgeWeights.size());
        assertEquals("[0.16, 0.19, 0.26, 0.17, 0.28, 0.35, 0.4]", edgeWeights.toString());

    }
}