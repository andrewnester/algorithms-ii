package com.nester.algorithms.graphs.directed;

import com.nester.structures.DirectedEdge;
import com.nester.structures.DirectedEdgeWeightedGraph;
import com.nester.structures.IndexedPriorityQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DijkstraAlgorithm {

    private DirectedEdge[] edgeTo;

    private double[] distTo;

    private IndexedPriorityQueue<Double> priorityQueue;

    public DijkstraAlgorithm(DirectedEdgeWeightedGraph graph, int source) {
        edgeTo = new DirectedEdge[graph.getVertexCount()];
        distTo = new double[graph.getVertexCount()];
        priorityQueue = new IndexedPriorityQueue<>(graph.getVertexCount());

        for (int vertex = 0; vertex < graph.getVertexCount(); vertex++) {
            distTo[vertex] = Double.POSITIVE_INFINITY;
        }

        distTo[source] = 0.0;
        priorityQueue.insert(source, 0.0);

        while (!priorityQueue.isEmpty()) {
            int vertex = priorityQueue.removeWithIndex();
            for (DirectedEdge edge : graph.getIncidentEdges(vertex)) {
                relax(edge);
            }
        }
    }

    public double distTo(int vertex) {
        return distTo[vertex];
    }

    public Iterable<DirectedEdge> pathTo(int vertex) {
        Deque<DirectedEdge> path = new ArrayDeque<>();
        for (DirectedEdge edge = edgeTo[vertex]; edge != null; edge = edgeTo[edge.from()]) {
            path.add(edge);
        }

        return path;
    }

    private void relax(DirectedEdge edge) {
        int firstVertex = edge.from(), secondVertex = edge.to();
        if (distTo[secondVertex] > distTo[firstVertex] + edge.weight()) {
            distTo[secondVertex] = distTo[firstVertex] + edge.weight();
            edgeTo[secondVertex] = edge;

            if (priorityQueue.contains(secondVertex)) {
                double value = priorityQueue.get(secondVertex);
                value -= distTo[secondVertex];
                priorityQueue.change(secondVertex, value);
            } else {
                priorityQueue.insert(secondVertex, distTo[secondVertex]);
            }
        }
    }
}
