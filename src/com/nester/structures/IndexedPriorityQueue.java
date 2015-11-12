package com.nester.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IndexedPriorityQueue<T> extends PriorityQueue<T> {

    private List<T> indexedQueue;

    public IndexedPriorityQueue(int size) {
        indexedQueue = new ArrayList<>(size);
        for(int i =0; i< size; i++) {
            indexedQueue.add(null);
        }
    }


    @Override
    public T remove() {
        T item = super.remove();
        int index = indexedQueue.indexOf(item);
        indexedQueue.set(index, null);
        return item;
    }

    public int removeWithIndex() {
        T item = super.remove();
        int index = indexedQueue.indexOf(item);
        indexedQueue.set(index, null);
        return index;
    }

    public T get(int index) {
        return indexedQueue.get(index);
    }

    public boolean contains(int index) {
        boolean isContains = true;

        try {
            indexedQueue.get(index);
        } catch(IndexOutOfBoundsException e) {
            isContains = false;
        }

        return isContains && indexedQueue.get(index) != null;
    }

    public void change(int index, T item) {
        if(!contains(index)) {
            throw new IllegalArgumentException();
        }

        T oldItem = indexedQueue.get(index);
        indexedQueue.set(index, item);
        remove(oldItem);
        add(item);

    }

    public void insert(int index, T item) {
        indexedQueue.set(index, item);
        super.add(item);
    }
}
