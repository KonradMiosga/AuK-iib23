package com.education.hszg.sort.impl;

import com.education.hszg.sort.api.IntSorter;

public class MergeSort implements IntSorter {

    @Override
    public int[] sort(int[] intArray) {
        if (intArray.length <= 1) {
            return intArray;
        }
        mergeSort(intArray, 0, intArray.length - 1);
        return intArray;
    }
    //Implementiert die sort-Methode des IntSorter-Interfaces und ruft die Methode mergeSort auf, wenn das Array mehr als ein Element hat.

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);        // sort the left part
            mergeSort(array, middle + 1, right);   // sort the right part
            merge(array, left, middle, right);     // merge both halves
        }
    }
    //Die rekursive Methode, die das Array in der Mitte teilt und die beiden Hälften sortiert, bevor sie sie zusammenführt.

    private void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);                //left = startIndex, leftArray = Zielarray, 0 = Start an Stelle 0, n1 = length
        System.arraycopy(array, middle + 1, rightArray, 0, n2);  //middle+1 = startIndex, rightArray = Zielarray, 0 = Start an Stelle 0, n2 = length

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    //Führt zwei sortierte Hälften (leftArray und rightArray) zusammen, indem sie zu einem vollständig sortierten Teilarray kombiniert werden.

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        System.out.println("MergeSort");
        int[] liste = {6, 2, 1, 3, 7, 8, 5, 9, 4, 5};

        System.out.println("Before Sort");
        for (int i = 0; i < liste.length; i++) {
            System.out.print(liste[i] + " | ");
        }

        System.out.println("\nAfter Sort");
        liste = mergeSort.sort(liste);
        for (int i = 0; i < liste.length; i++) {
            System.out.print(liste[i] + " | ");
        }
    }
    //Die main-Methode testet die Implementierung von MergeSort, indem sie ein Array vor und nach der Sortierung ausgibt.
}
