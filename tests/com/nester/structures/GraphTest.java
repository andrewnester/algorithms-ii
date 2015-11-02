package com.nester.structures;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GraphTest {

    @Test
    public void createGraphFromInputStream() {
        String testString = "5\n0 1\n0 3\n1 3\n1 4\n3 4\n";

        try {
            BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8)));
            GraphInterface graph = getTestGraphFromInputStream(is);
            testGraph(graph);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test(expected = IOException.class)
    public void createGraphFromInputStreamWithIOException() throws IOException {
        String testString = "5\n0 1\n0 3\n1 3\n1 4\n3 4\n";

        BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8)));
        is.close();
        getTestGraphFromInputStream(is);
    }

    @Test
    public void getVertexCount() {
        GraphInterface graph = getTestGraph(5);

        Assert.assertEquals("Vertex count is not equal expected one", 5, graph.getVertexCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addEdgeOutOfBounds() {
        GraphInterface graph = getTestGraph(5);
        graph.addEdge(1, 10);
    }

    @Test
    public void addEdgeAndGetAdjacentVertices() {
        GraphInterface graph = getTestGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);

        testGraph(graph);
    }

    protected GraphInterface getTestGraph(int vertexCount) {
        return new Graph(vertexCount);
    }

    protected GraphInterface getTestGraphFromInputStream(InputStream is) throws IOException {
        return new Graph(is);
    }

    protected void testGraph(GraphInterface graph) {
        Iterable<Integer> vertices = graph.getAdjacentVertices(0);
        List<Integer> adjacentVertices = new ArrayList<>();
        for (Integer vertex : vertices) {
            adjacentVertices.add(vertex);
        }

        Assert.assertEquals("Not all vertices returned as adjacent ones for vertex 0", 2, adjacentVertices.size());
        Assert.assertTrue("Not all vertices returned as adjacent ones", adjacentVertices.contains(1));
        Assert.assertTrue("Not all vertices returned as adjacent ones", adjacentVertices.contains(3));

        vertices = graph.getAdjacentVertices(1);
        adjacentVertices = new ArrayList<>();
        for (Integer vertex : vertices) {
            adjacentVertices.add(vertex);
        }

        Assert.assertEquals("Not all vertices returned as adjacent ones for vertex 1", 3, adjacentVertices.size());
        Assert.assertTrue("Not all vertices returned as adjacent ones", adjacentVertices.contains(0));
        Assert.assertTrue("Not all vertices returned as adjacent ones", adjacentVertices.contains(3));
        Assert.assertTrue("Not all vertices returned as adjacent ones", adjacentVertices.contains(4));

        vertices = graph.getAdjacentVertices(2);
        adjacentVertices = new ArrayList<>();
        for (Integer vertex : vertices) {
            adjacentVertices.add(vertex);
        }

        Assert.assertEquals("Not empty vertices for vertex 2", 0, adjacentVertices.size());

        vertices = graph.getAdjacentVertices(3);
        adjacentVertices = new ArrayList<>();
        for (Integer vertex : vertices) {
            adjacentVertices.add(vertex);
        }

        Assert.assertEquals("Not all vertices returned as adjacent ones for vertex 3", 3, adjacentVertices.size());
        Assert.assertTrue("Not all vertices returned as adjacent ones", adjacentVertices.contains(0));
        Assert.assertTrue("Not all vertices returned as adjacent ones", adjacentVertices.contains(1));
        Assert.assertTrue("Not all vertices returned as adjacent ones", adjacentVertices.contains(4));

        vertices = graph.getAdjacentVertices(4);
        adjacentVertices = new ArrayList<>();
        for (Integer vertex : vertices) {
            adjacentVertices.add(vertex);
        }

        Assert.assertEquals("Not all vertices returned as adjacent ones for vertex 4", 2, adjacentVertices.size());
        Assert.assertTrue("Not all vertices returned as adjacent ones", adjacentVertices.contains(1));
        Assert.assertTrue("Not all vertices returned as adjacent ones", adjacentVertices.contains(3));
    }

}
