package com.nester.algorithms.graph;

import java.io.InputStream;

/**
 * Class Graph
 *
 * Implement Adjacency-lists graph representation
 */
public class Graph {

    private final int vertexCount;

    private Bag<Integer>[] adjacentVertexes;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjacentVertexes = (Bag<Integer>[]) new Bag[vertexCount];
    }

    public Graph(InputStream inputStream) {
        //TODO: need to be implemented
        this.vertexCount = 0;
    }

    /**
     * Add new edge between 2 vertexes
     *
     * @param firstVertex First vertex of the edge
     * @param secondVertex Second vertex of the edge
     */
    public void addEdge(int firstVertex, int secondVertex) {
        adjacentVertexes[firstVertex].add(secondVertex);
        adjacentVertexes[secondVertex].add(firstVertex);
    }

    /**
     * Returns adjacent vertexes for vertex passed
     *
     * @param vertex Vertex what adjacent must be returned for
     * @return Iterator to iterate over adjacent vertex
     */
    public Iterable<Integer> getAdjacentVertexes(int vertex) {
        return adjacentVertexes[vertex];
    }

    /**
     * @return Return vertex count
     */
    public int getVertexCount() {
        return vertexCount;
    }

    /**
     *
     * @return Edge counts
     */
    public int getEdgeCount() {
        //TODO: need to be implemented
        return 0;
    }

    public String toString() {
        return "Graph{}";
    }
}
