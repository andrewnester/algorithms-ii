package com.nester.algorithms.graphs.undirected;

import com.nester.algorithms.graphs.undirected.helper.GraphHelper;
import com.nester.algorithms.structures.Graph;
import org.junit.Assert;
import org.junit.Test;

public class ConnectedComponentsTest {

    @Test
    public void isConnected() {
        Graph graph = GraphHelper.createTestGraph();

        ConnectedComponents connectedComponents = new ConnectedComponents(graph);

        Assert.assertTrue("Vertices 0 and 1 must be connected", connectedComponents.isConnected(0, 1));
        Assert.assertTrue("Vertices 0 and 2 must be connected", connectedComponents.isConnected(0, 2));
        Assert.assertTrue("Vertices 1 and 2 must be connected", connectedComponents.isConnected(1, 2));
        Assert.assertTrue("Vertices 2 and 3 must be connected", connectedComponents.isConnected(2, 3));
        Assert.assertTrue("Vertices 0 and 3 must be connected", connectedComponents.isConnected(0, 3));

        Assert.assertFalse("Vertices 0 and 7 must not be connected", connectedComponents.isConnected(0, 7));
    }

    @Test
    public void count() {
        Graph graph = GraphHelper.createTestGraph();

        ConnectedComponents connectedComponents = new ConnectedComponents(graph);

        Assert.assertEquals("Wrong connected components count", 2, connectedComponents.count());
    }

    @Test
    public void id() {
        Graph graph = GraphHelper.createTestGraph();

        ConnectedComponents connectedComponents = new ConnectedComponents(graph);

        Assert.assertEquals("Wrong connected component id for vertex 0 ", 0, connectedComponents.id(0));
        Assert.assertEquals("Wrong connected component id for vertex 1 ", 0, connectedComponents.id(1));
        Assert.assertEquals("Wrong connected component id for vertex 2 ", 0, connectedComponents.id(2));
        Assert.assertEquals("Wrong connected component id for vertex 3 ", 0, connectedComponents.id(3));
        Assert.assertEquals("Wrong connected component id for vertex 4 ", 0, connectedComponents.id(4));
        Assert.assertEquals("Wrong connected component id for vertex 5 ", 0, connectedComponents.id(5));
        Assert.assertEquals("Wrong connected component id for vertex 6 ", 0, connectedComponents.id(6));
        Assert.assertEquals("Wrong connected component id for vertex 7 ", 1, connectedComponents.id(7));
    }

}
