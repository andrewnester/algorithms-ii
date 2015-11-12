package com.nester.algorithms.graphs.undirected;

import com.nester.structures.Edge;
import com.nester.structures.EdgeWeightedGraph;
import com.nester.structures.IndexedPriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EagerPrimAlgorithm implements PrimAlgorithmImplementation {

    private Edge[] edgeTo;

    private double[] distTo;

    private boolean[] marked;

    private IndexedPriorityQueue<Double> priorityQueue;

    @Override
    public void run(EdgeWeightedGraph graph) {

        edgeTo = new Edge[graph.getVertexCount()];
        distTo = new double[graph.getVertexCount()];
        marked = new boolean[graph.getVertexCount()];

        for (int v = 0; v < graph.getVertexCount(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        priorityQueue = new IndexedPriorityQueue<>(graph.getVertexCount());

        distTo[0] = 0.0;
        priorityQueue.insert(0, 0.0);
        while (!priorityQueue.isEmpty()) {
            visit(graph, priorityQueue.removeWithIndex());
        }
    }

    @Override
    public Iterable<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        edges.addAll(Arrays.asList(edgeTo).subList(1, edgeTo.length));
        return edges;
    }

    private void visit(EdgeWeightedGraph graph, int vertex) {
        marked[vertex] = true;
        for (Edge edge : graph.getIncidentEdges(vertex)) {
            int otherVertex = edge.other(vertex);
            if (marked[otherVertex]) {
                continue;
            }
            if (edge.weight() < distTo[otherVertex]) {
                edgeTo[otherVertex] = edge;
                distTo[otherVertex] = edge.weight();
                if (priorityQueue.contains(otherVertex)) {
                    priorityQueue.change(otherVertex, distTo[otherVertex]);
                } else {
                    priorityQueue.insert(otherVertex, distTo[otherVertex]);
                }
            }
        }
    }
}
