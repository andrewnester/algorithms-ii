package com.nester.algorithms.graphs.undirected;

import com.nester.structures.Edge;
import com.nester.structures.EdgeWeightedGraph;

public class PrimAlgorithm {

    private PrimAlgorithmImplementation implementation;

    public PrimAlgorithm(PrimAlgorithmImplementation implementation, EdgeWeightedGraph graph) {
        this.implementation = implementation;
        this.implementation.run(graph);
    }

    public Iterable<Edge> getEdges() {
        return this.implementation.getEdges();
    }
}
