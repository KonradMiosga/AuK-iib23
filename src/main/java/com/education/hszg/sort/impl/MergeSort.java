package com.education.hszg.sort.impl;

import com.education.hszg.sort.api.IntSorter;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements IntSorter {


    @Override
    public int[] sort(int[] numbers) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            intList.add(numbers[i]);
        }

        List<Integer> sortedList = mergeSort(intList);

        for (int i = 0; i < sortedList.size(); i++) {
            numbers[i] = sortedList.get(i);
        }

        return numbers;
    }

    private List<Integer> mergeSort(List<Integer> intList){
        if(intList.size() <=1)
            return intList;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int pivot = intList.get(0);

        for(int i = 0; i < intList.size(); i++){
            if(i < intList.size() / 2){
                left.add(intList.get(i));
            }else{
                right.add(intList.get(i));
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        left = mergeSort(left);
        right = mergeSort(right);

        while( left.size() + right.size() > 0 ){
            if(left.isEmpty()) {
                sortedList.add(right.remove(0));
            } else if(right.isEmpty()) {
                sortedList.add(left.remove(0));
            } else if(left.get(0) < right.get(0)) {
                sortedList.add(left.remove(0));
            } else{
                sortedList.add(right.remove(0));
            }
        }

        return sortedList;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        System.out.println("MergeSort");
        int[] liste = { 6,2,1,3,7,8,5,9,4,5};


        System.out.println("Before Sort");
        for (int i = 0; i < liste.length; i++) {
            System.out.print(liste[i] + " | ");
        }

        int[] sortedList = mergeSort.sort(liste);

        System.out.println("\nAfter Sort");
        for (int i = 0; i < sortedList.length; i++) {
            System.out.print(sortedList[i] + " | ");
        }
    }
}