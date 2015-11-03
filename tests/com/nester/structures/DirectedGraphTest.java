package com.nester.structures;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DirectedGraphTest extends GraphTest {

    @Test
    public void reverse() {
        DirectedGraph graph = new DirectedGraph(3);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        DirectedGraph reversedGraph = graph.reverse();

        Iterable<Integer> vertices = reversedGraph.getAdjacentVertices(0);
        List<Integer> adjacentVertices = new ArrayList<>();
        for (Integer vertex : vertices) {
            adjacentVertices.add(vertex);
        }

        Assert.assertEquals("[2]", adjacentVertices.toString());

        vertices = reversedGraph.getAdjacentVertices(1);
        adjacentVertices = new ArrayList<>();
        for (Integer vertex : vertices) {
            adjacentVertices.add(vertex);
        }

        Assert.assertEquals("[0]", adjacentVertices.toString());

        vertices = reversedGraph.getAdjacentVertices(2);
        adjacentVertices = new ArrayList<>();
        for (Integer vertex : vertices) {
            adjacentVertices.add(vertex);
        }

        Assert.assertEquals("[1]", adjacentVertices.toString());
    }

    protected GraphInterface getTestGraph(int vertexCount) {
        return new DirectedGraph(vertexCount);
    }

    protected GraphInterface getTestGraphFromInputStream(InputStream is) throws IOException {
        return new DirectedGraph(is);
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

        Assert.assertEquals("Not all vertices returned as adjacent ones for vertex 1", 2, adjacentVertices.size());
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

        Assert.assertEquals("Not all vertices returned as adjacent ones for vertex 3", 1, adjacentVertices.size());
        Assert.assertTrue("Not all vertices returned as adjacent ones", adjacentVertices.contains(4));

        vertices = graph.getAdjacentVertices(4);
        adjacentVertices = new ArrayList<>();
        for (Integer vertex : vertices) {
            adjacentVertices.add(vertex);
        }

        Assert.assertEquals("Not empty vertices for vertex 4", 0, adjacentVertices.size());
    }

}
