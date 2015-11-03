package com.nester.algorithms.graphs.directed;

import com.nester.base.ReverseList;
import com.nester.structures.DirectedGraph;

import java.util.*;

/**
 * Class DeepFirstOrder
 * Used to order graph based on DFS algorithm
 */
public class DeepFirstOrder {

    private boolean[] marked;

    private List<Integer> preOrder;

    private List<Integer> postOrder;

    public DeepFirstOrder(DirectedGraph graph) {
        marked = new boolean[graph.getVertexCount()];
        preOrder = new ArrayList<>();
        postOrder = new ArrayList<>();

        for (int vertex = 0; vertex < graph.getVertexCount(); vertex++) {
            if (!marked[vertex]) {
                dfs(graph, vertex);
            }
        }
    }

    /**
     * Returns graph pre-order
     *
     * @return Graph pre-order path
     */
    public Iterable<Integer> getPreOrder() {
        return preOrder;
    }

    /**
     * Returns graph post-order
     *
     * @return Graph post-order path
     */
    public Iterable<Integer> getPostOrder() {
        return postOrder;
    }

    /**
     * Returns graph reverse post-order
     *
     * @return Graph reverse post-order path
     */
    public Iterable<Integer> getReversePostOrder() {
        return new ReverseList<>(postOrder);
    }

    /**
     * Runs DFS to create different orders of graph
     *
     * @param graph      Graph to be processed
     * @param baseVertex Vertex to process
     */
    private void dfs(DirectedGraph graph, int baseVertex) {
        preOrder.add(baseVertex);
        marked[baseVertex] = true;

        for (int vertex : graph.getAdjacentVertices(baseVertex)) {
            if (!marked[vertex]) {
                dfs(graph, vertex);
            }
        }

        postOrder.add(baseVertex);
    }


}
