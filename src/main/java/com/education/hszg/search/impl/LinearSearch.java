package com.education.hszg.search.impl;

import com.education.hszg.search.api.IntSearcher;

public class LinearSearch implements IntSearcher {

    /**
     * uses linear search
     * returns true if num is in array
     * @param array an int[]
     * @param num number to search for
     * @return is num in int[]
     */
    @Override
    public boolean search(int[] array, int num) {
        for (int i : array) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }
}
