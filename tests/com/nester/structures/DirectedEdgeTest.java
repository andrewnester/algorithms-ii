package com.nester.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectedEdgeTest {

    private DirectedEdge edge;

    @Before
    public void setUp() throws Exception {
        edge = new DirectedEdge(1, 2, 0.678);
    }

    @Test
    public void testFrom() {
        assertEquals(1, edge.from());
    }

    @Test
    public void testTo() {
        assertEquals(2, edge.to());
    }

    @Test
    public void testCompareTo()  {
        DirectedEdge equalEdge = new DirectedEdge(5, 6, 0.678);
        DirectedEdge lessEdge = new DirectedEdge(7, 8, 0.5);
        DirectedEdge moreEdge = new DirectedEdge(3, 4, 1);

        Assert.assertTrue(edge.compareTo(equalEdge) == 0);
        Assert.assertTrue(edge.compareTo(lessEdge) == 1);
        Assert.assertTrue(edge.compareTo(moreEdge) == -1);
    }

    @Test
    public void testWeight() {
        assertTrue(Double.compare(0.678, edge.weight()) == 0);
    }
}