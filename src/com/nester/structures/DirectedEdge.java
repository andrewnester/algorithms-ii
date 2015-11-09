package com.nester.structures;

/**
 * Class DirectedEdge
 * <p/>
 * Represents directed edge that is used to build directed edge-weighted graphs
 */
public class DirectedEdge {

    private int from;

    private int to;

    private double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    /**
     * Returns vertex what edge comes from
     *
     * @return Start vertex
     */
    public int from() {
        return from;
    }

    /**
     * Returns vertex what edge comes to
     *
     * @return End vertex
     */
    public int to() {
        return to;
    }

    /**
     * Returns weight of the edge
     *
     * @return Edge weight
     */
    public double weight() {
        return weight;
    }

}
