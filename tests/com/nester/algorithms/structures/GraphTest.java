package com.nester.algorithms.structures;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GraphTest {

    @Test
    public void createGraphFromInputStream() {
        String testString = "5\n0 1\n0 3\n1 3\n1 4\n3 4\n";
        Graph graph = new Graph(new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8)));

        testGraph(graph);
    }

    @Test
    public void getVertexCount() {
        Graph graph = new Graph(5);

        Assert.assertEquals("Vertex count is not equal expected one", 5, graph.getVertexCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addEdgeOutOfBounds() {
        Graph graph = new Graph(5);
        graph.addEdge(1, 10);
    }

    @Test
    public void addEdgeAndGetAdjacentVertexes() {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);

        testGraph(graph);
    }

    private void testGraph(Graph graph) {
        Iterable<Integer> vertexes = graph.getAdjacentVertexes(0);
        List<Integer> adjacentVertexes = new ArrayList<>();
        for(Integer vertex: vertexes) {
            adjacentVertexes.add(vertex);
        }

        Assert.assertEquals("Not all vertexes returned as adjacent ones for vertex 0", 2, adjacentVertexes.size());
        Assert.assertTrue("Not all vertexes returned as adjacent ones", adjacentVertexes.contains(1));
        Assert.assertTrue("Not all vertexes returned as adjacent ones", adjacentVertexes.contains(3));

        vertexes = graph.getAdjacentVertexes(1);
        adjacentVertexes = new ArrayList<>();
        for(Integer vertex: vertexes) {
            adjacentVertexes.add(vertex);
        }

        Assert.assertEquals("Not all vertexes returned as adjacent ones for vertex 1", 3, adjacentVertexes.size());
        Assert.assertTrue("Not all vertexes returned as adjacent ones", adjacentVertexes.contains(0));
        Assert.assertTrue("Not all vertexes returned as adjacent ones", adjacentVertexes.contains(3));
        Assert.assertTrue("Not all vertexes returned as adjacent ones", adjacentVertexes.contains(4));

        vertexes = graph.getAdjacentVertexes(2);
        adjacentVertexes = new ArrayList<>();
        for(Integer vertex: vertexes) {
            adjacentVertexes.add(vertex);
        }

        Assert.assertEquals("Not empty vertexes for vertex 2", 0, adjacentVertexes.size());

        vertexes = graph.getAdjacentVertexes(3);
        adjacentVertexes = new ArrayList<>();
        for(Integer vertex: vertexes) {
            adjacentVertexes.add(vertex);
        }

        Assert.assertEquals("Not all vertexes returned as adjacent ones for vertex 3", 3, adjacentVertexes.size());
        Assert.assertTrue("Not all vertexes returned as adjacent ones", adjacentVertexes.contains(0));
        Assert.assertTrue("Not all vertexes returned as adjacent ones", adjacentVertexes.contains(1));
        Assert.assertTrue("Not all vertexes returned as adjacent ones", adjacentVertexes.contains(4));
    }

}
