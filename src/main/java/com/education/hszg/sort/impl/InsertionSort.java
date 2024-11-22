package com.education.hszg.sort.impl;

import com.education.hszg.sort.api.IntSorter;

public class InsertionSort implements IntSorter {
    @Override
    public int[] sort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int temp = numbers[i];
            int j = i;
            while (j > 0 && numbers[j - 1] > temp){
                numbers[j] = numbers[j-1];
                j--;
            }
            numbers[j] = temp;
        }
        return numbers;
    }
}
