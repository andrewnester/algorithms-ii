package com.nester.algorithms.graphs.undirected;

import com.nester.helpers.GraphHelper;
import com.nester.structures.Edge;
import com.nester.structures.EdgeWeightedGraph;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EagerPrimAlgorithmTest {

    @Test
    public void testEagerPrimAlgorithm() throws Exception {
        EdgeWeightedGraph graph = GraphHelper.createTestEdgeWeightedGraph();

        EagerPrimAlgorithm epa = new EagerPrimAlgorithm();

        epa.run(graph);
        Iterable<Edge> edges = epa.getEdges();

        ArrayList<Double> edgeWeights = new ArrayList<>();
        for (Edge e : edges) {
            edgeWeights.add(e.weight());
        }

        assertEquals(7, edgeWeights.size());
        assertEquals("[0.19, 0.26, 0.17, 0.35, 0.28, 0.4, 0.16]", edgeWeights.toString());

    }
}