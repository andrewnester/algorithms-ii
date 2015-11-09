package com.nester.structures;


import java.util.ArrayList;
import java.util.List;

public class DirectedEdgeWeightedGraph {

    private int vertexCount;

    private List<List<DirectedEdge>> adjacentVertices;

    public DirectedEdgeWeightedGraph(int vertexCount) {
        this.vertexCount = vertexCount;

        adjacentVertices = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            adjacentVertices.add(new ArrayList<DirectedEdge>());
        }
    }

    /**
     * Add new directed weighted edge to graph
     *
     * @param edge Directed edge to be added
     */
    public void addEdge(DirectedEdge edge) {
        int from = edge.from();
        adjacentVertices.get(from).add(edge);
    }

    /**
     * Returns incident edges for vertex passed
     *
     * @param vertex Vertex what incident edges must be returned for
     * @return Iterator to iterate over incident edges
     */
    public Iterable<DirectedEdge> getIncidentEdges(int vertex) {
        return adjacentVertices.get(vertex);
    }


    public int getVertexCount() {
        return vertexCount;
    }

}
