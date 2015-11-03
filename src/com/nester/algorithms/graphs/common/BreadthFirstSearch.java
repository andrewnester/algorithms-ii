package com.nester.algorithms.graphs.common;

import com.nester.structures.GraphInterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Class BreadthFirstSearch
 * Implements breadth-first search algorithms on graphs
 */
public class BreadthFirstSearch implements GraphSearchInterface {

    private boolean[] marked;

    private int[] edgeTo;

    private int[] distances;

    private Queue<Integer> sources;

    public BreadthFirstSearch(GraphInterface graph, int source) {

        marked = new boolean[graph.getVertexCount()];
        edgeTo = new int[graph.getVertexCount()];
        distances = new int[graph.getVertexCount()];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        sources = new LinkedList<>(queue);

        bfs(graph, queue);
    }

    public BreadthFirstSearch(GraphInterface graph, Queue<Integer> queue) {

        marked = new boolean[graph.getVertexCount()];
        edgeTo = new int[graph.getVertexCount()];
        distances = new int[graph.getVertexCount()];
        sources = new LinkedList<>(queue);

        bfs(graph, queue);
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
        int v;
        for (v = vertex; !sources.contains(v); v = edgeTo[v]) {
            path.push(v);
        }

        path.push(v);
        return path;
    }

    /**
     * Returns distance from source vertex to passed one
     *
     * @param vertex Destination vertex
     * @return Distance from source vertex to destination one
     */
    public int distance(int vertex) {
        return distances[vertex];
    }

    /**
     * Runs breadth-first search
     *
     * @param graph Graph to be processed
     * @param queue Pre-initialized queue to be processed
     */
    private void bfs(GraphInterface graph, Queue<Integer> queue) {

        while (!queue.isEmpty()) {
            int baseVertex = queue.remove();

            for (int vertex : graph.getAdjacentVertices(baseVertex)) {
                if (!marked[vertex]) {
                    queue.add(vertex);
                    marked[vertex] = true;
                    edgeTo[vertex] = baseVertex;
                    distances[vertex] = distances[baseVertex] + 1;
                }
            }

            marked[baseVertex] = true;
        }
    }

}
