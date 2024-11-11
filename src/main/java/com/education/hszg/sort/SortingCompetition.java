package com.education.hszg.sort;

import com.education.hszg.sort.impl.*;

import java.util.*;

public class SortingCompetition {

    public static void main(String[] args) {
        //Zufallszahlen
        int size = 200_000;
        Random random = new Random();
        int[] dummyNumbers = new int[size];
        for (int i = 0; i < size; i++)
            dummyNumbers[i] = random.nextInt(size);

        int[] bubbleArray = dummyNumbers.clone();
        long bs_before = System.currentTimeMillis();
        new BubbleSort().sort(bubbleArray);
        long bs_after = System.currentTimeMillis();
        System.out.println("BubbleSort braucht " + (bs_after - bs_before) + "ms bzw. " + (bs_after - bs_before) / 1000 + "s");

        int[] selectionArray = dummyNumbers.clone();
        long ss_before = System.currentTimeMillis();
        new SelectionSort().sort(selectionArray);
        long ss_after = System.currentTimeMillis();
        System.out.println("SelectionSort braucht " + (ss_after - ss_before) + "ms bzw. " + (ss_after - ss_before) / 1000 + "s");

        int[] quickArray = dummyNumbers.clone();
        long qs_before = System.currentTimeMillis();
        new QuickSort().sort(quickArray);
        long qs_after = System.currentTimeMillis();
        System.out.println("QuickSort braucht " + (qs_after - qs_before) + "ms bzw. " + (qs_after - qs_before) / 1000 + "s");

        int[] mergeArray = dummyNumbers.clone();
        long ms_before = System.currentTimeMillis();
        new MergeSort().sort(mergeArray);
        long ms_after = System.currentTimeMillis();
        System.out.println("MergeSort braucht " + (ms_after - ms_before) + "ms bzw. " + (ms_after - ms_before) / 1000 + "s");

        int[] insertionArray = dummyNumbers.clone();
        long is_before = System.currentTimeMillis();
        new InsertionSort().sort(insertionArray);
        long is_after = System.currentTimeMillis();
        System.out.println("InsertionSort braucht " + (is_after - is_before) + "ms bzw. " + (is_after - is_before) / 1000 + "s");
    }
}