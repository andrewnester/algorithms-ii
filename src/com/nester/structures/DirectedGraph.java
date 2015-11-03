package com.nester.structures;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class DirectedGraph
 * Implements Adjacency-lists directed graph representation
 */
public class DirectedGraph extends Graph implements GraphInterface {

    public DirectedGraph(int vertexCount) {
        super(vertexCount);
    }

    public DirectedGraph(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    /**
     * Add new edge between 2 vertices
     *
     * @param firstVertex  First vertex of the edge
     * @param secondVertex Second vertex of the edge
     */
    @Override
    public void addEdge(int firstVertex, int secondVertex) throws IndexOutOfBoundsException {
        ArrayList<List<Integer>> adjacentVertices = getAdjacentVerticesList();

        // checking if in-vertex is not out of bounds
        if(secondVertex >= getVertexCount()) {
            throw new IndexOutOfBoundsException();
        }
        adjacentVertices.get(firstVertex).add(secondVertex);
    }


    /**
     * Returns reversed graph (all graph edges reversed)
     *
     * @return Reversed graph
     */
    public DirectedGraph reverse() {
        int vertexCount = getVertexCount();
        DirectedGraph reversedGraph = new DirectedGraph(vertexCount);

        for(int vertex = 0; vertex < vertexCount; vertex++) {
            for(int adjacentVertex : getAdjacentVertices(vertex)) {
                reversedGraph.addEdge(adjacentVertex, vertex);
            }
        }

        return reversedGraph;
    }

}
