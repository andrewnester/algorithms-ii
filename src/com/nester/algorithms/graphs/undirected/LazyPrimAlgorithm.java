package com.nester.algorithms.graphs.undirected;

import com.nester.structures.Edge;
import com.nester.structures.EdgeWeightedGraph;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimAlgorithm implements PrimAlgorithmImplementation {

    private boolean[] marked;

    private Queue<Edge> mst;

    private PriorityQueue<Edge> priorityQueue;

    @Override
    public void run(EdgeWeightedGraph graph) {
        marked = new boolean[graph.getVertexCount()];
        mst = new ArrayDeque<>();
        priorityQueue = new PriorityQueue<>();

        visit(graph, 0);

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.remove();
            int firstVertex = edge.either(), secondVertex = edge.other(firstVertex);
            if(marked[firstVertex] && marked[secondVertex]) {
                continue;
            }

            mst.add(edge);
            if(!marked[firstVertex]) {
                visit(graph, firstVertex);
            }

            if(!marked[secondVertex]) {
                visit(graph, secondVertex);
            }
        }
    }

    @Override
    public Iterable<Edge> getEdges() {
        return mst;
    }

    private void visit(EdgeWeightedGraph graph, int vertex) {
        marked[vertex] = true;
        for (Edge edge : graph.getIncidentEdges(vertex)) {
            if (!marked[edge.other(vertex)]) {
                priorityQueue.add(edge);
            }
        }
    }
}
