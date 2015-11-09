package com.nester.structures;

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
    public void testWeight() {
        assertTrue(Double.compare(0.678, edge.weight()) == 0);
    }
}