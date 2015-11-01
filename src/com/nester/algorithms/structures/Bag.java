package com.nester.algorithms.structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Bag
 * Implements basic Bag structure API for generic items
 *
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {

    private Node<Item> first;    // beginning of bag
    private int N;               // number of elements in bag

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        N = 0;
    }


    /**
     * Checks whether bag is empty or not
     *
     * @return true if bag has no items, otherwise - false
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Add new generic item to the bag
     *
     * @param item Item to be added
     */
    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    /**
     * Method used to check size of the bag
     *
     * @return Size of the bag. For empty bag returns 0
     */
    public int size() {
        return N;
    }

    /**
     * Returns simple iterator to iterate over bag
     * Actually it doesn't matter how iterator is implemented, cuz we don't care about its order
     *
     * @return Iterator to iterate over bag
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    /**
     * @param <Item>
     */
    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public ListIterator(Node<Item> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}