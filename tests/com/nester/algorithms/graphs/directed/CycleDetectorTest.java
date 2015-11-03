package com.nester.algorithms.graphs.directed;

import com.nester.helpers.GraphHelper;
import com.nester.structures.DirectedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CycleDetectorTest {

    @Test
    public void cycleDetection() {

        DirectedGraph cycledGraph = GraphHelper.createTestCycledDirectedGraph();
        CycleDetector cycleDetector = new CycleDetector(cycledGraph);

        Assert.assertTrue("Cycle detector hasn't detected existing cycle", cycleDetector.hasCycle());

        ArrayList<Integer> expectedCycle = new ArrayList<>();
        expectedCycle.add(0);
        expectedCycle.add(1);
        expectedCycle.add(5);
        expectedCycle.add(2);

        Iterable<Integer> cycle = cycleDetector.cycle();

        int size = 0;
        for(int vertex: cycle) {
            size++;
            Assert.assertTrue("Wrong cycled detected", expectedCycle.contains(vertex));
        }
        Assert.assertEquals("Wrong cycled detected", expectedCycle.size(), size);

        DirectedGraph graph = GraphHelper.createTestDirectedGraph();
        cycleDetector = new CycleDetector(graph);

        cycle = cycleDetector.cycle();
        Assert.assertFalse("Cycle detector has detected non-existing cycle", cycleDetector.hasCycle());
        Assert.assertNull(cycle);
    }

}
