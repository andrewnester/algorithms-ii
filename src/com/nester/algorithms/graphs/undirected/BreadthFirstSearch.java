package com.nester.algorithms.graphs.undirected;

import com.nester.structures.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class BreadthFirstSearch
 * Implements breadth-first search algorithms on graphs
 */
public class BreadthFirstSearch implements GraphSearchInterface {

    private int source;

    private boolean[] marked;

    private int[] edgeTo;

    public BreadthFirstSearch(Graph graph, int source) {
        this.source = source;
        marked = new boolean[graph.getVertexCount()];
        edgeTo = new int[graph.getVertexCount()];

        bfs(graph, source);
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

        Stack<Integer> path = new Stack<>();
        for (int v = vertex; v != source; v = edgeTo[v]) {
            path.push(v);
        }

        path.push(source);
        return path;
    }

    /**
     * Runs breadth-first search
     *
     * @param graph  Graph to be processed
     * @param source Vertex what path should be found for
     */
    private void bfs(Graph graph, int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        marked[source] = true;

        while (!queue.isEmpty()) {
            int baseVertex = queue.remove();
            for (int vertex : graph.getAdjacentVertices(baseVertex)) {
                if (!marked[vertex]) {
                    queue.add(vertex);
                    marked[vertex] = true;
                    edgeTo[vertex] = baseVertex;
                }
            }
        }
    }

}
