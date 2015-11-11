package com.nester.algorithms.basic;

/**
 * Class UnionFind
 * Implements union find algorithm
 */
public class UnionFind {

    private int count;

    private int[] id;

    public UnionFind(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    /**
     * Union 2 object in the same component
     *
     * @param p First object
     * @param q Second object
     */
    public void union(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }

        count--;

    }

    /**
     * Find component for specified object
     *
     * @param p Object to find
     * @return Component id
     */
    public int find(int p) {
        return id[p];
    }

    /**
     * Checks if 2 objects are connected
     *
     * @param p First object
     * @param q Second object
     * @return True if 2 objects connected, otherwise - false
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Return count of components
     *
     * @return Components count
     */
    public int count() {
        return count;
    }
}
