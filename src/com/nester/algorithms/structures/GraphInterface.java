package com.nester.algorithms.structures;

/**
 * Interface GraphInterface
 * Represents basic Graph API
 */
public interface GraphInterface {
    void addEdge(int firstVertex, int secondVertex) throws IndexOutOfBoundsException;

    Iterable<Integer> getAdjacentVertices(int vertex);

    int getVertexCount();
}
