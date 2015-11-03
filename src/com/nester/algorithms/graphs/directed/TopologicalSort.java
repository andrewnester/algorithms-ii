package com.nester.algorithms.graphs.directed;


import com.nester.structures.DirectedGraph;


public class TopologicalSort {

    private Iterable<Integer> order;

    public TopologicalSort(DirectedGraph graph) {
        CycleDetector cycleDetector = new CycleDetector(graph);
        if(!cycleDetector.hasCycle()) {
            DeepFirstOrder dfo = new DeepFirstOrder(graph);
            order = dfo.getReversePostOrder();
        }
    }

    /**
     * Checks if graph is DAG (Directed acyclic graph)
     *
     * @return True if graph is DAG, otherwise - false
     */
    public boolean isDAG() {
        return order != null;
    }

    /**
     * Return vertices in topological order of graph
     *
     * @return Vertices in topological order
     */
    public Iterable<Integer> order() {
        return order;
    }
}
