package com.nester.algorithms.graphs.undirected;

/**
 * Interface GraphSearchInterface
 * Represents interface for searching algorithms on graphs
 */
public interface GraphSearchInterface {

    /**
     * Checks if path exists in graph
     *
     * @param vertex Destination point of path
     * @return true if graph has path from source to vertex, otherwise - false
     */
    boolean hasPathTo(int vertex);

    /**
     * Returns all vertexes lying on the path
     *
     * @param vertex Destination point of path
     * @return iteratable structure to iterate over vertexes that is lying on the path from source to vertex
     */
    Iterable<Integer> pathTo(int vertex);
}
