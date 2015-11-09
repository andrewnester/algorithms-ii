package com.nester.structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EdgeTest {

    private Edge edge;

    @Before
    public void setUp() throws Exception {
        edge = new Edge(1, 2, 0.678);
    }

    @Test
    public void testEither() {
        Assert.assertEquals(1, edge.either());
    }

    @Test
    public void testOther() {
        Assert.assertEquals(1, edge.other(2));
        Assert.assertEquals(2, edge.other(1));
    }

    @Test
    public void testCompareTo()  {
        Edge equalEdge = new Edge(5, 6, 0.678);
        Edge lessEdge = new Edge(7, 8, 0.5);
        Edge moreEdge = new Edge(3, 4, 1);

        Assert.assertTrue(edge.compareTo(equalEdge) == 0);
        Assert.assertTrue(edge.compareTo(lessEdge) == 1);
        Assert.assertTrue(edge.compareTo(moreEdge) == -1);
    }

    @Test
    public void testWeight() {
        Assert.assertTrue(Double.compare(0.678, edge.weight()) == 0);
    }
}