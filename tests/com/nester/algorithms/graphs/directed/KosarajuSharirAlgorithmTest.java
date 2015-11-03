package com.nester.algorithms.graphs.directed;

import com.nester.helpers.GraphHelper;
import org.junit.Assert;
import org.junit.Test;

public class KosarajuSharirAlgorithmTest {

    @Test
    public void getStrongConnectedAlgorithm() {
        KosarajuSharirAlgorithm ksa = new KosarajuSharirAlgorithm(GraphHelper.createTestDirectedGraphWithComponents());

        Assert.assertEquals("Wrong components count", 5, ksa.count());

        Assert.assertTrue(ksa.isStronglyConnected(0, 3));
        Assert.assertTrue(ksa.isStronglyConnected(6, 8));
        Assert.assertTrue(ksa.isStronglyConnected(11, 10));

        Assert.assertFalse(ksa.isStronglyConnected(0, 1));
        Assert.assertFalse(ksa.isStronglyConnected(0, 6));
        Assert.assertFalse(ksa.isStronglyConnected(9, 6));
        Assert.assertFalse(ksa.isStronglyConnected(4, 11));

        Assert.assertEquals(2, ksa.id(2));
        Assert.assertEquals(3, ksa.id(8));
        Assert.assertEquals(4, ksa.id(7));
    }

}
