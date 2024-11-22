package com.education.hszg.sort.impl;

import com.education.hszg.sort.api.IntSorter;

public class BubbleSort implements IntSorter {

    @Override
    public int[] sort(int[] numbers) {
        boolean swapped;
        for (int i = 0; i < numbers.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < (numbers.length - 1); j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = new int[]{5, 4, 3, 2, 1};
        arr = bubbleSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
