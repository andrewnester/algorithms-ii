package com.nester.algorithms.graphs.common;

import com.nester.structures.GraphInterface;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Class DeepFirstSearch
 * Implements deep-first search algorithm
 */
public class DeepFirstSearch implements GraphSearchInterface {

    private int source;

    private boolean[] marked;

    private int[] edgeTo;

    public DeepFirstSearch(GraphInterface graph, int source) {
        this.source = source;
        marked = new boolean[graph.getVertexCount()];
        edgeTo = new int[graph.getVertexCount()];

        dfs(graph, source);
    }

    /**
     * Checks if path exists in graph
     *
     * @param vertex Destination point of path
     * @return true if graph has path from source to vertex, otherwise - false
     */
    @Override
    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    /**
     * Returns all vertices lying on the path
     *
     * @param vertex Destination point of path
     * @return iteratable structure to iterate over vertices that is lying on the path from source to vertex
     */
    @Override
    public Iterable<Integer> pathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            return null;
        }

        Deque<Integer> path = new ArrayDeque<>();
        for (int v = vertex; v != source; v = edgeTo[v]) {
            path.push(v);
        }

        path.push(source);
        return path;
    }

    /**
     * Runs deep-first search
     *
     * @param graph  Graph to be processed
     * @param source Vertex what path should be found for
     */
    private void dfs(GraphInterface graph, int source) {
        marked[source] = true;

        for (int vertex : graph.getAdjacentVertices(source)) {
            if (!marked[vertex]) {
                dfs(graph, vertex);
                edgeTo[vertex] = source;
            }
        }
    }

}
