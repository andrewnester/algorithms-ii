package com.nester.algorithms.graphs.common;

import com.nester.helpers.GraphHelper;
import com.nester.structures.GraphInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchTest {

    @Test
    public void undirectedGraphHasPathTo() {
        GraphInterface graph = GraphHelper.createTestGraph();

        GraphSearchInterface bfs = getAlgorithm(graph, 0);
        Assert.assertTrue("Vertex 0 must have path to vertex 1", bfs.hasPathTo(1));
        Assert.assertTrue("Vertex 0 must have path to vertex 2", bfs.hasPathTo(2));
        Assert.assertTrue("Vertex 0 must have path to vertex 3", bfs.hasPathTo(3));
        Assert.assertTrue("Vertex 0 must have path to vertex 4", bfs.hasPathTo(4));
        Assert.assertTrue("Vertex 0 must have path to vertex 5", bfs.hasPathTo(5));
        Assert.assertTrue("Vertex 0 must have path to vertex 5", bfs.hasPathTo(6));

        Assert.assertFalse("Vertex 0 must not have path to vertex 7", bfs.hasPathTo(7));

    }

    @Test
    public void directedGraphHasPathTo() {
        GraphInterface graph = GraphHelper.createTestDirectedGraph();

        GraphSearchInterface bfs = getAlgorithm(graph, 0);
        Assert.assertTrue("Vertex 0 must have path to vertex 1", bfs.hasPathTo(1));
        Assert.assertTrue("Vertex 0 must have path to vertex 3", bfs.hasPathTo(3));
        Assert.assertTrue("Vertex 0 must have path to vertex 5", bfs.hasPathTo(5));
        Assert.assertTrue("Vertex 0 must have path to vertex 4", bfs.hasPathTo(4));
        Assert.assertTrue("Vertex 0 must have path to vertex 6", bfs.hasPathTo(6));

        Assert.assertFalse("Vertex 0 must not have path to vertex 2", bfs.hasPathTo(2));
        Assert.assertFalse("Vertex 0 must not have path to vertex 7", bfs.hasPathTo(7));

    }

    @Test
    public void undirectedGraphPathToNonConnectedVertex() {
        GraphInterface graph = GraphHelper.createTestGraph();

        GraphSearchInterface bfs = getAlgorithm(graph, 0);
        Assert.assertNull("Vertex 0 must not have path to vertex 7", bfs.pathTo(7));
    }

    @Test
    public void directedGraphPathToNonConnectedVertex() {
        GraphInterface graph = GraphHelper.createTestDirectedGraph();

        GraphSearchInterface bfs = getAlgorithm(graph, 0);
        Assert.assertNull("Vertex 0 must not have path to vertex 2", bfs.pathTo(2));
        Assert.assertNull("Vertex 0 must not have path to vertex 7", bfs.pathTo(7));
    }


    @Test
    public void undirectedGraphPathTo() {
        GraphInterface graph = GraphHelper.createTestGraph();

        GraphSearchInterface bfs = getAlgorithm(graph, 0);
        Iterable<Integer> path = bfs.pathTo(5);

        List<Integer> vertices = new ArrayList<>();
        for (Integer vertex : path) {
            vertices.add(vertex);
        }

        Assert.assertEquals("Wrong path to vertex 5 from 0", 2, vertices.size());
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertices.contains(5));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertices.contains(0));
    }

    @Test
    public void directedGraphPathTo() {
        GraphInterface graph = GraphHelper.createTestDirectedGraph();

        GraphSearchInterface bfs = getAlgorithm(graph, 0);
        Iterable<Integer> path = bfs.pathTo(5);

        List<Integer> vertices = new ArrayList<>();
        for (Integer vertex : path) {
            vertices.add(vertex);
        }

        Assert.assertEquals("Wrong path to vertex 5 from 0", 4, vertices.size());
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertices.contains(5));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertices.contains(4));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertices.contains(3));
        Assert.assertTrue("Wrong path to vertex 5 from 0", vertices.contains(0));

        bfs = getAlgorithm(graph, 0);
        path = bfs.pathTo(6);

        vertices = new ArrayList<>();
        for (Integer vertex : path) {
            vertices.add(vertex);
        }

        Assert.assertEquals("Wrong path to vertex 6 from 0", 2, vertices.size());
        Assert.assertTrue("Wrong path to vertex 6 from 0", vertices.contains(6));
        Assert.assertTrue("Wrong path to vertex 6 from 0", vertices.contains(0));
    }

    @Test
    public void undirectedGraphDistance() {
        GraphInterface graph = GraphHelper.createTestGraph();
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);

        Assert.assertEquals("Wrong distance to vertex 1", 1, bfs.distance(1));
        Assert.assertEquals("Wrong distance to vertex 2", 1, bfs.distance(2));
        Assert.assertEquals("Wrong distance to vertex 5", 1, bfs.distance(5));
        Assert.assertEquals("Wrong distance to vertex 6", 1, bfs.distance(6));

        Assert.assertEquals("Wrong distance to vertex 3", 2, bfs.distance(3));
        Assert.assertEquals("Wrong distance to vertex 4", 2, bfs.distance(4));
    }

    @Test
    public void directedGraphDistance() {
        GraphInterface graph = GraphHelper.createTestDirectedGraph();
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);

        Assert.assertEquals("Wrong distance to vertex 1", 1, bfs.distance(1));
        Assert.assertEquals("Wrong distance to vertex 4", 1, bfs.distance(4));
        Assert.assertEquals("Wrong distance to vertex 6", 1, bfs.distance(6));

        Assert.assertEquals("Wrong distance to vertex 3", 2, bfs.distance(3));

        Assert.assertEquals("Wrong distance to vertex 5", 3, bfs.distance(5));
    }

    @Test
    public void multiSourceTest() {
        GraphInterface graph = GraphHelper.createTestGraph();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(0);
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, queue);

        Assert.assertTrue("This graph must have path to 6 from 0 or 3 ", bfs.hasPathTo(6));

        Iterable<Integer> path = bfs.pathTo(6);
        List<Integer> vertices = new ArrayList<>();
        for (Integer vertex : path) {
            vertices.add(vertex);
        }

        Assert.assertEquals("Shortest path to vertex 6 from 0", 2, vertices.size());
        Assert.assertTrue("Wrong shortest path to vertex 6 from 0", vertices.contains(6));
        Assert.assertTrue("Wrong shortest path to vertex 6 from 0", vertices.contains(0));


        graph = GraphHelper.createTestDirectedGraph();

        queue = new LinkedList<>();
        queue.add(0);
        queue.add(3);
        bfs = new BreadthFirstSearch(graph, queue);

        Assert.assertTrue("This graph must have path to 5 from 0 or 3 ", bfs.hasPathTo(5));

        path = bfs.pathTo(5);
        vertices = new ArrayList<>();
        for (Integer vertex : path) {
            vertices.add(vertex);
        }

        Assert.assertEquals("Shortest path to vertex 5 from 3", 2, vertices.size());
        Assert.assertTrue("Wrong shortest path to vertex 5 from 3", vertices.contains(5));
        Assert.assertTrue("Wrong shortest path to vertex 5 from 3", vertices.contains(3));

    }

    protected GraphSearchInterface getAlgorithm(GraphInterface graph, int source) {
        return new BreadthFirstSearch(graph, source);
    }
}
