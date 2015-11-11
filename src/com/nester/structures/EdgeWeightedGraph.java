package com.nester.structures;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {

    private final int vertexCount;

    private final List<List<Edge>> adjacentVertices;

    public EdgeWeightedGraph(int vertexCount) {
        this.vertexCount = vertexCount;

        adjacentVertices = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            adjacentVertices.add(new ArrayList<Edge>());
        }
    }

    /**
     * Add new weighted edge to graph
     *
     * @param edge Edge to be added to graph
     */
    public void addEdge(Edge edge) {
        int firstVertex = edge.either(), secondVertex = edge.other(firstVertex);

        adjacentVertices.get(firstVertex).add(edge);
        adjacentVertices.get(secondVertex).add(edge);
    }


    /**
     * Returns incident edges for vertex passed
     *
     * @param vertex Vertex what incident edges must be returned for
     * @return Iterator to iterate over incident edges
     */
    public Iterable<Edge> getIncidentEdges(int vertex) {
        return adjacentVertices.get(vertex);
    }

    /**
     * Returns all graph edges
     *
     * @return Graph edges
     */
    public Iterable<Edge> getEdges() {
        ArrayList<Edge> edges = new ArrayList<>();
        for(List<Edge> adjacentEdges: adjacentVertices) {
            for(Edge edge: adjacentEdges) {
                if(!edges.contains(edge)) {
                    edges.add(edge);
                }
            }
        }

        return edges;
    }


    public int getVertexCount() {
        return vertexCount;
    }
}
