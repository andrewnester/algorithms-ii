package com.nester.structures;

/**
 * Class Edge
 *
 * Represents edge for edge-weighted graph
 */
public class Edge {

    private int firstVertex;

    private int secondVertex;

    private double weight;

    public Edge(int firstVertex, int secondVertex, double weight) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.weight = weight;
    }

    /**
     * Returns one of vertexes
     *
     * @return Returns one of vertex
     */
    public int either() {
        return firstVertex;
    }

    /**
     * Returns other vertex comparing with passed
     *
     * @param vertex Vertex of edge
     * @return Other vertex
     */
    public int other(int vertex) {
        return vertex == firstVertex ? secondVertex : firstVertex;
    }

    public int compareTo(Edge edge) {
        if(weight < edge.weight) {
            return -1;
        } else if( weight > edge.weight) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Returns weight of edge
     *
     * @return Edge weight
     */
    public double weight() {
        return weight;
    }
}
