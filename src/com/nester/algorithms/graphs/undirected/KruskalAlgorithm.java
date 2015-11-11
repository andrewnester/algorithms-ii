package com.nester.algorithms.graphs.undirected;

import com.nester.algorithms.basic.UnionFind;
import com.nester.structures.Edge;
import com.nester.structures.EdgeWeightedGraph;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalAlgorithm {

    private Queue<Edge> mst = new ArrayDeque<>();

    public KruskalAlgorithm(EdgeWeightedGraph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (Edge edge : graph.getEdges()) {
            queue.add(edge);
        }

        UnionFind uf = new UnionFind(graph.getVertexCount());
        while (!queue.isEmpty() && mst.size() < graph.getVertexCount() - 1) {
            Edge edge = queue.remove();
            int firstVertex = edge.either(), secondVertex = edge.other(firstVertex);
            if (!uf.connected(firstVertex, secondVertex)) {
                uf.union(firstVertex, secondVertex);
                mst.add(edge);
            }
        }
    }

    public Iterable<Edge> getEdges() {
        return mst;
    }
}
