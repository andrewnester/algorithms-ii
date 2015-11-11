package com.nester.algorithms.basic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UnionFindTest {

    private UnionFind uf;

    @Before
    public void setUp() throws Exception {
        uf = new UnionFind(10);
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(3, 4);
        uf.union(1, 2);

        uf.union(5, 7);
        uf.union(7, 8);
        uf.union(9, 2);

    }

    @Test
    public void testFind() throws Exception {
        assertEquals(0, uf.find(0));

        assertEquals(4, uf.find(1));
        assertEquals(4, uf.find(2));
        assertEquals(4, uf.find(3));
        assertEquals(4, uf.find(2));
        assertEquals(4, uf.find(9));

        assertEquals(8, uf.find(7));
        assertEquals(8, uf.find(5));
    }

    @Test
    public void testConnected() throws Exception {
        assertTrue(uf.connected(1, 2));
        assertTrue(uf.connected(1, 9));
        assertTrue(uf.connected(5, 7));
        assertTrue(uf.connected(5, 8));

        assertFalse(uf.connected(1, 0));
    }

    @Test
    public void testCount() throws Exception {
        assertEquals(4, uf.count());
    }
}