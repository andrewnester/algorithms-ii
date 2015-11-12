package com.nester.algorithms.graphs.undirected;

import com.nester.structures.Edge;
import com.nester.structures.EdgeWeightedGraph;

public interface PrimAlgorithmImplementation {

    void run(EdgeWeightedGraph graph);

    Iterable<Edge> getEdges();

}
