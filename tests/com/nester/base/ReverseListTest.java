package com.nester.base;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class ReverseListTest {

    @Test
    public void reverse() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        Iterable<Integer> reverseList = new ReverseList<>(list);

        ArrayList<Integer> resultList = new ArrayList<>();
        for(int i : reverseList) {
            resultList.add(i);
        }

        Assert.assertEquals("[3, 2, 1, 0]", resultList.toString());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        Iterator<Integer> reverseListIterator = new ReverseList<>(new ArrayList<Integer>()).iterator();
        reverseListIterator.remove();
    }
}
