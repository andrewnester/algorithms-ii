package com.nester.algorithms.graphs.directed;


import com.nester.structures.DirectedEdge;
import com.nester.structures.DirectedEdgeWeightedGraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BellmannFord {

    private double[] distTo;

    private DirectedEdge[] edgeTo;

    private boolean[] onQueue;

    private Queue<Integer> queue;

    private int cost;

    private Iterable<DirectedEdge> cycle;

    public BellmannFord(DirectedEdgeWeightedGraph graph, int source) {

        distTo = new double[graph.getVertexCount()];
        edgeTo = new DirectedEdge[graph.getVertexCount()];
        onQueue = new boolean[graph.getVertexCount()];
        for (int v = 0; v < graph.getVertexCount(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[source] = 0.0;

        queue = new ArrayDeque<>();
        queue.add(source);
        onQueue[source] = true;

        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.remove();
            onQueue[v] = false;
            relax(graph, v);
        }
    }

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }


    public double distTo(int v) {
        return distTo[v];
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Deque<DirectedEdge> path = new ArrayDeque<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    private void relax(DirectedEdgeWeightedGraph graph, int baseVertex) {
        for (DirectedEdge e : graph.getIncidentEdges(baseVertex)) {
            int vertex = e.to();
            if (distTo[vertex] > distTo[baseVertex] + e.weight()) {
                distTo[vertex] = distTo[baseVertex] + e.weight();
                edgeTo[vertex] = e;
                if (!onQueue[vertex]) {
                    queue.add(vertex);
                    onQueue[vertex] = true;
                }
            }
            if (cost++ % graph.getVertexCount() == 0) {
                findNegativeCycle();
            }
        }
    }

    private void findNegativeCycle() {
        int vertexCount = edgeTo.length;
        DirectedEdgeWeightedGraph spt = new DirectedEdgeWeightedGraph(vertexCount);
        for (DirectedEdge anEdgeTo : edgeTo) {
            if (anEdgeTo != null) {
                spt.addEdge(anEdgeTo);
            }

        }

        EdgeWeightedCycleDetector detector = new EdgeWeightedCycleDetector(spt);
        cycle = detector.cycle();
    }
}
