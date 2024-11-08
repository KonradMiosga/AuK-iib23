package com.education.hszg.sort;

import java.util.Random;
import com.education.hszg.sort.api.IntSorter;
import com.education.hszg.sort.impl.BubbleSort;
import com.education.hszg.sort.impl.SelectionSort;

public class SortingCompetition {
    public static void main(String[] args) {
        IntSorter sort = new BubbleSort();
        Random random = new Random();
        int maxSize = 100_000;
        int[] arr = random.ints(maxSize, 0, maxSize).toArray();

        double startTime = System.currentTimeMillis();
        sort.sort(arr);
        double endTime = System.currentTimeMillis();
        System.out.println("bubble sort: " + (endTime-startTime) + " ms");

        sort = new SelectionSort();
        startTime = System.currentTimeMillis();
        sort.sort(arr);
        endTime = System.currentTimeMillis();
        System.out.println("selection sort: " + (endTime-startTime) + " ms");

    }
}
