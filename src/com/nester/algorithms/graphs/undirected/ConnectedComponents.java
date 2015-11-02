package com.nester.algorithms.graphs.undirected;

import com.nester.algorithms.structures.Graph;

/**
 * Class ConnectedComponents
 * Used to find connected components in graph using depth-first search
 */
public class ConnectedComponents {

    private boolean[] marked;

    private int[] id;

    private int count;

    public ConnectedComponents(Graph graph) {
        marked = new boolean[graph.getVertexCount()];
        id = new int[graph.getVertexCount()];
        count = 0;

        for(int vertex = 0; vertex < graph.getVertexCount(); vertex++) {
            if(!marked[vertex]) {
                dfs(graph, vertex);
                count++;
            }
        }
    }

    /**
     * Checks if 2 vertices are connected (belong the same component)
     *
     * @param firstVertex First vertex to check
     * @param secondVertex Second vertex to check
     * @return true if 2 vertex connected, otherwise - false
     */
    public boolean isConnected(int firstVertex, int secondVertex) {
        return id(firstVertex) == id(secondVertex);
    }

    /**
     * Return component count
     *
     * @return Component count
     */
    public int count() {
        return count;
    }

    /**
     * Returns component id for specified vertex
     *
     * @param vertex Vertex component id will be found for
     * @return Component id
     */
    public int id(int vertex) {
        return id[vertex];
    }

    /**
     * Runs deep-first search to calculate connected components
     *
     * @param graph Graph to be processed
     * @param baseVertex Vertex to process
     */
    private void dfs(Graph graph, int baseVertex) {
        marked[baseVertex] = true;
        id[baseVertex] = count;

        for(int vertex: graph.getAdjacentVertices(baseVertex)) {
            if(!marked[vertex]) {
                dfs(graph, vertex);
            }
        }
    }
}
