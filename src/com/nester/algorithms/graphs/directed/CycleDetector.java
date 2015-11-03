package com.nester.algorithms.graphs.directed;

import com.nester.structures.DirectedGraph;

import java.util.Stack;

/**
 * Class CycleDetector
 * Used to detect cycles in directed graphs
 */
public class CycleDetector {

    private boolean[] marked;

    private int[] edgeTo;

    private Stack<Integer> cycle;

    private boolean[] onStack;

    public CycleDetector(DirectedGraph graph) {
        marked = new boolean[graph.getVertexCount()];
        onStack = new boolean[graph.getVertexCount()];
        edgeTo = new int[graph.getVertexCount()];

        for (int vertex = 0; vertex < graph.getVertexCount(); vertex++) {
            if (!marked[vertex] && !hasCycle()) {
                dfs(graph, vertex);
            }
        }

    }

    /**
     * Checks if graph has cycle or not
     *
     * @return true if graph has 1 or more cycles, otherwise - false
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * Returns detected cycle
     *
     * @return Detected cycle
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }

    /**
     * Runs DFS to detect cycles
     *
     * @param graph      Directed graph to be processed
     * @param baseVertex Start vertex to process
     */
    private void dfs(DirectedGraph graph, int baseVertex) {
        marked[baseVertex] = true;
        onStack[baseVertex] = true;

        for (int vertex : graph.getAdjacentVertices(baseVertex)) {
            if (hasCycle()) {
                return;
            }

            if (onStack[vertex]) {
                cycle = new Stack<>();
                for (int v = baseVertex; v != vertex; v = edgeTo[v]) {
                    cycle.push(v);
                }
                cycle.push(vertex);
                return;
            }

            if (!marked[vertex]) {
                edgeTo[vertex] = baseVertex;
                marked[vertex] = true;
                dfs(graph, vertex);
            }
        }

        onStack[baseVertex] = false;
    }
}
