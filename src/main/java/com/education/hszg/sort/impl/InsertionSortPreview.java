package com.education.hszg.sort.impl;

import com.education.hszg.sort.api.IntSorter;

public class InsertionSortPreview implements IntSorter {
    @Override
    public int[] sort(int[] arr){
        // going through each value of the array
        for (int i = 0; i < arr.length; i++){
            int value = arr[i];
            int j = i;
            // going through sorted part to find the right spot for value
            while (j > 0 && arr[j - 1] > value){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = value;
        }
        return arr;
    }
}
