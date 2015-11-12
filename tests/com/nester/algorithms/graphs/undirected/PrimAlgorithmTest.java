package com.nester.algorithms.graphs.undirected;

import com.nester.helpers.GraphHelper;
import com.nester.structures.EdgeWeightedGraph;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PrimAlgorithmTest {

    @Test
    public void testPrimAlgorithm() throws Exception {
        PrimAlgorithmImplementation implementation = mock(PrimAlgorithmImplementation.class);
        EdgeWeightedGraph graph = GraphHelper.createTestEdgeWeightedGraph();
        PrimAlgorithm pa = new PrimAlgorithm(implementation, graph);

        pa.getEdges();

        verify(implementation).run(graph);
        verify(implementation).getEdges();

    }
}