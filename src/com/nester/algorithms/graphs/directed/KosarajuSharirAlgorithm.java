package com.nester.algorithms.graphs.directed;

import com.nester.structures.DirectedGraph;

/**
 * Class KosarajuSharirAlgorithm
 * <p/>
 * Implements Kosaraju-Sharir algorithm to find
 * strongly connected components in direct graphs
 */
public class KosarajuSharirAlgorithm {

    private boolean[] marked;

    private int[] componentIDs;

    private int componentCount;

    public KosarajuSharirAlgorithm(DirectedGraph graph) {
        marked = new boolean[graph.getVertexCount()];
        componentIDs = new int[graph.getVertexCount()];

        DeepFirstOrder dfo = new DeepFirstOrder(graph.reverse());
        for (int vertex : dfo.getReversePostOrder()) {
            if (!marked[vertex]) {
                dfs(graph, vertex);
                componentCount++;
            }
        }
    }

    /**
     * Checks if 2 vertices are strongly connected
     *
     * @param firstVertex First vertex to check
     * @param secondVertex Second vertex to check
     *
     * @return True if 2 vertices are strongly connected, false - otherwise
     */
    public boolean isStronglyConnected(int firstVertex, int secondVertex) {
        return componentIDs[firstVertex] == componentIDs[secondVertex];
    }

    /**
     * Returns component ID for specified vertex
     *
     * @param vertex Vertex to process
     * @return Component ID
     */
    public int id(int vertex) {
        return componentIDs[vertex];
    }

    /**
     * Returns count of strong components
     *
     * @return Count of strong components
     */
    public int count() {
        return componentCount;
    }

    /**
     * Runs DFS to identify strongly connected components
     *
     * @param graph      Graph to be processed
     * @param baseVertex Vertex to be processed
     */
    private void dfs(DirectedGraph graph, int baseVertex) {
        marked[baseVertex] = true;
        componentIDs[baseVertex] = componentCount;
        for (int vertex : graph.getAdjacentVertices(baseVertex)) {
            if (!marked[vertex]) {
                dfs(graph, vertex);
            }
        }
    }


}
