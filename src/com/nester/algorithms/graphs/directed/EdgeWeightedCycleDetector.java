package com.nester.algorithms.graphs.directed;

import com.nester.structures.DirectedEdge;
import com.nester.structures.DirectedEdgeWeightedGraph;
import com.nester.structures.DirectedGraph;
import com.nester.structures.Edge;

import java.util.ArrayList;
import java.util.List;

/**
 * Class CycleDetector
 * Used to detect cycles in directed graphs
 */
public class EdgeWeightedCycleDetector {

    private boolean[] marked;

    private DirectedEdge[] edgeTo;

    private List<DirectedEdge> cycle;

    private boolean[] onStack;


    public EdgeWeightedCycleDetector(DirectedEdgeWeightedGraph graph) {
        marked = new boolean[graph.getVertexCount()];
        onStack = new boolean[graph.getVertexCount()];
        edgeTo = new DirectedEdge[graph.getVertexCount()];

        for (int vertex = 0; vertex < graph.getVertexCount(); vertex++) {
            if (!marked[vertex]) {
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
    public Iterable<DirectedEdge> cycle() {
        return cycle;
    }

    /**
     * Runs DFS to detect cycles
     *
     * @param graph      Directed graph to be processed
     * @param baseVertex Start vertex to process
     */
    private void dfs(DirectedEdgeWeightedGraph graph, int baseVertex) {
        marked[baseVertex] = true;
        onStack[baseVertex] = true;

        for (DirectedEdge edge : graph.getIncidentEdges(baseVertex)) {
            if (hasCycle()) {
                return;
            }

            int vertex = edge.to();

            if (!marked[vertex]) {
                edgeTo[vertex] = edge;
                dfs(graph, vertex);
            } else if (onStack[vertex]) {
                cycle = new ArrayList<>();
                while (edge.from() != vertex) {
                    cycle.add(edge);
                    edge = edgeTo[edge.from()];
                }
                cycle.add(edge);
                return;
            }


        }

        onStack[baseVertex] = false;
    }
}
