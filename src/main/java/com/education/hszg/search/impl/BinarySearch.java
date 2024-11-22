package com.education.hszg.search.impl;

import com.education.hszg.search.api.IntSearcher;

public class BinarySearch implements IntSearcher {
    /**
     * überprüft: ist ein Element im Array
     * @param array array aus int zahlen
     * @param num die gesuchte zahl
     * @return true wenn num in array ist, sonst false
     */
    @Override
    public boolean search(int[] array, int num) {
        int left = 0;
        int right = array.length - 1;
        int pivot;

        while (left <= right) {
            pivot = left + (right - left) / 2;

            if (array[pivot] < num) {
                left = pivot + 1;

            } else if (array[pivot] > num) {
                right = pivot - 1;

            } else {
                return true;
            }
        }

        return false;
    }
}
