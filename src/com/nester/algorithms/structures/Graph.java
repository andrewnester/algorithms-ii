package com.nester.algorithms.structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Class Graph
 * <p/>
 * Implement Adjacency-lists graph representation
 */
public class Graph {

    private int vertexCount;

    private ArrayList<Bag<Integer>> adjacentVertices;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjacentVertices = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            adjacentVertices.add(new Bag<Integer>());
        }
    }

    public Graph(InputStream inputStream) throws IOException {

        vertexCount = 0;
        adjacentVertices = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = in.readLine()) != null) {
            String[] splittedLine = line.split(" ");
            if (splittedLine.length == 1) {
                vertexCount = Integer.parseInt(splittedLine[0]);
                for (int i = 0; i < vertexCount; i++) {
                    adjacentVertices.add(new Bag<Integer>());
                }
            } else {
                addEdge(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[1]));
            }

        }

    }

    /**
     * Add new edge between 2 vertices
     *
     * @param firstVertex  First vertex of the edge
     * @param secondVertex Second vertex of the edge
     */
    public void addEdge(int firstVertex, int secondVertex) throws IndexOutOfBoundsException {
        adjacentVertices.get(firstVertex).add(secondVertex);
        adjacentVertices.get(secondVertex).add(firstVertex);

    }

    /**
     * Returns adjacent vertices for vertex passed
     *
     * @param vertex Vertex what adjacent must be returned for
     * @return Iterator to iterate over adjacent vertex
     */
    public Iterable<Integer> getAdjacentVertices(int vertex) {
        return adjacentVertices.get(vertex);
    }

    /**
     * @return Return vertex count
     */
    public int getVertexCount() {
        return vertexCount;
    }
}
