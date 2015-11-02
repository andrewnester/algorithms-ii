package com.nester.algorithms.structures;

import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;
import java.util.List;

public class BagTest {

    @Test
    public void isEmpty() {
        Bag<Integer> bag = new Bag<>();
        Assert.assertTrue("Bag is not empty", bag.isEmpty());
    }

    @Test
    public void size() {
        Bag<Integer> bag = new Bag<>();

        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);

        Assert.assertEquals("Bag size is not equal expected one", 4, bag.size());
    }

    @Test
    public void addAndIterate() {

        List<Integer> testNumbers = Arrays.asList(10, 21, 32, 43, 54);
        Bag<Integer> bag = new Bag<>();

        for(Integer number: testNumbers) {
            bag.add(number);
        }

        assert testNumbers.size() == bag.size();

        for (Integer number : bag) {
            Assert.assertTrue("Different numbers in bag and test list", testNumbers.contains(number));
        }

    }

}
