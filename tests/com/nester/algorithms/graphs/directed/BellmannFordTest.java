package com.nester.algorithms.graphs.directed;

import com.nester.helpers.GraphHelper;
import com.nester.structures.DirectedEdge;
import com.nester.structures.DirectedEdgeWeightedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class BellmannFordTest {

    @Test
    public void testHasNegativeCycle() throws Exception {

        DirectedEdgeWeightedGraph graph = GraphHelper.createTestDirectedNegativeCycledEdgeWeightedGraph();
        BellmannFord bf = new BellmannFord(graph, 0);
        Assert.assertTrue(bf.hasNegativeCycle());

        graph = GraphHelper.createTestDirectedCycledEdgeWeightedGraph();
        bf = new BellmannFord(graph, 0);
        Assert.assertFalse(bf.hasNegativeCycle());

        graph = GraphHelper.createTestDirectedEdgeWeightedGraph();
        bf = new BellmannFord(graph, 0);
        Assert.assertFalse(bf.hasNegativeCycle());

    }

    @Test
    public void testNegativeCycle() throws Exception {
        DirectedEdgeWeightedGraph graph = GraphHelper.createTestDirectedNegativeCycledEdgeWeightedGraph();
        BellmannFord bf = new BellmannFord(graph, 0);
        Assert.assertTrue(bf.hasNegativeCycle());

        Iterable<DirectedEdge> edges = bf.negativeCycle();
        ArrayList<Double> weights = new ArrayList<>();
        for(DirectedEdge edge: edges) {
            weights.add(edge.weight());
        }

        Assert.assertEquals("[-0.66, 0.28, 0.37]", weights.toString());
    }

    @Test
    public void testHasPathTo() throws Exception {

        DirectedEdgeWeightedGraph graph = GraphHelper.createTestDirectedNegativeCycledEdgeWeightedGraph();
        BellmannFord bf = new BellmannFord(graph, 0);

        Assert.assertTrue(bf.hasPathTo(4));
        Assert.assertTrue(bf.hasPathTo(2));
        Assert.assertTrue(bf.hasPathTo(6));
        Assert.assertTrue(bf.hasPathTo(3));

        graph = GraphHelper.createTestDirectedNegativeCycledEdgeWeightedGraph();
        bf = new BellmannFord(graph, 1);

        Assert.assertTrue(bf.hasPathTo(5));
        Assert.assertTrue(bf.hasPathTo(7));
        Assert.assertTrue(bf.hasPathTo(6));
        Assert.assertTrue(bf.hasPathTo(3));


    }

    @Test
    public void testDistTo() throws Exception {

        DirectedEdgeWeightedGraph graph = GraphHelper.createTestDirectedEdgeWeightedGraph();
        BellmannFord bf = new BellmannFord(graph, 0);

        Assert.assertTrue(Double.compare(5.0, bf.distTo(1)) == 0);
        Assert.assertTrue(Double.compare(14.0, bf.distTo(2)) == 0);
        Assert.assertTrue(Double.compare(17.0, bf.distTo(3)) == 0);
        Assert.assertTrue(Double.compare(9.0, bf.distTo(4)) == 0);
        Assert.assertTrue(Double.compare(13.0, bf.distTo(5)) == 0);
        Assert.assertTrue(Double.compare(25.0, bf.distTo(6)) == 0);
        Assert.assertTrue(Double.compare(8.0, bf.distTo(7)) == 0);
    }

    @Test
    public void testPathTo() throws Exception {
        DirectedEdgeWeightedGraph graph = GraphHelper.createTestDirectedEdgeWeightedGraph();
        BellmannFord bf = new BellmannFord(graph, 0);

        Iterable<DirectedEdge> edges = bf.pathTo(6);
        ArrayList<Double> weights = new ArrayList<>();
        for(DirectedEdge edge: edges) {
            weights.add(edge.weight());
        }

        Assert.assertEquals("[9.0, 4.0, 1.0, 11.0]", weights.toString());

    }
}