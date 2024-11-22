package com.education.hszg.sort.impl;

import com.education.hszg.sort.api.IntSorter;

public class SelectionSort implements IntSorter {
    @Override
    public int[] sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = numbers[minIndex];
            numbers[minIndex] = numbers[i];
            numbers[i] = temp;
        }
        return numbers;
    }
}
