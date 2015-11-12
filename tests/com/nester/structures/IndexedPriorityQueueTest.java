package com.nester.structures;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class IndexedPriorityQueueTest {

    private IndexedPriorityQueue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new IndexedPriorityQueue<>(20);
        queue.insert(0, "6");
        queue.insert(1, "2");
        queue.insert(2, "7");
        queue.insert(3, "3");
        queue.insert(4, "4");
        queue.insert(5, "9");
        queue.insert(6, "1");
        queue.insert(7, "8");
        queue.insert(8, "5");
    }

    @Test
    public void testRemove() throws Exception {
        ArrayList<String> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            list.add(queue.remove());
        }

        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());
    }

    @Test
    public void testRemoveWithIndex() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            list.add(queue.removeWithIndex());
        }

        assertEquals("[6, 1, 3, 4, 8, 0, 2, 7, 5]", list.toString());
    }

    @Test
    public void testContains() throws Exception {
        assertTrue(queue.contains(1));
        assertTrue(queue.contains(0));
        assertTrue(queue.contains(6));

        assertFalse(queue.contains(9));
        assertFalse(queue.contains(-1));

        queue.remove();
        assertFalse(queue.contains(6));
    }

    @Test
    public void testChange() throws Exception {
        queue.change(0, "0");
        assertEquals("0", queue.get(0));

        queue.change(0, "10");
        assertEquals("10", queue.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeIllegal() throws Exception {
        queue.change(11, "0");
    }

    @Test
    public void testGet() throws Exception {
        assertEquals("6", queue.get(0));
        assertEquals("2", queue.get(1));
        assertEquals("7", queue.get(2));
    }

    @Test
    public void testInsert() throws Exception {


        queue.insert(11, "0");
        queue.insert(10, "-1");
        queue.insert(9, "-2");

        assertEquals("-2", queue.get(9));
        assertEquals("-1", queue.get(10));
        assertEquals("0", queue.get(11));

        ArrayList<String> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            list.add(queue.remove());
        }

        assertEquals("[-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", list.toString());
    }
}