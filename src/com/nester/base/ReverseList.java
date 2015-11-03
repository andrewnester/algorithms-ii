package com.nester.base;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Class ReverseList
 *
 * Implements decorator to change iteration order to reversed
 */
public class ReverseList<T> implements Iterable<T> {

    private ListIterator<T> iterator;

    public ReverseList(List<T> list) {
        iterator = list.listIterator(list.size());
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return iterator.hasPrevious();
            }

            @Override
            public T next() {
                return iterator.previous();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
