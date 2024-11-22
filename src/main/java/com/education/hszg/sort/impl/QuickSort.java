package com.education.hszg.sort.impl;

import com.education.hszg.sort.api.IntSorter;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements IntSorter {


    @Override
    public int[] sort(int[] numbers) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            intList.add(numbers[i]);
        }

        List<Integer> sortedList = quickSort(intList);

        for (int i = 0; i < sortedList.size(); i++) {
            numbers[i] = sortedList.get(i);
        }

        return numbers;
    }

    private List<Integer> quickSort(List<Integer> intList){
        if(intList.size() <=1)
            return intList;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int pivot = intList.get(0);

        for(int i = 1; i < intList.size(); i++){
            if(intList.get(i) < pivot){
                left.add(intList.get(i));
            }else{
                right.add(intList.get(i));
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(quickSort(left));
        sortedList.add(pivot);
        sortedList.addAll(quickSort(right));

        return sortedList;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        System.out.println("QuickSort");
        int[] liste = {6, 2, 1, 3, 7, 8, 5, 9, 4, 5};

        System.out.println("Before Sort");
        for (int i = 0; i < liste.length; i++) {
            System.out.print(liste[i] + " | ");
        }

        int[] sortedList = quickSort.sort(liste);

        System.out.println("\nAfter Sort");
        for (int i = 0; i < sortedList.length; i++) {
            System.out.print(sortedList[i] + " | ");
        }
    }
}