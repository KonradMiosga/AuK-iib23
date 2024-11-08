package com.education.hszg.sort.impl;

import com.education.hszg.sort.api.IntSorter;

public class QuickSort implements IntSorter {

    @Override
    public int[] sort(int[] intArray) {
        if (intArray.length <= 1) {
            return intArray;
        }
        quickSort(intArray, 0, intArray.length - 1);
        return intArray;
    }
    // Implementiert die sort-Methode des IntSorter-Interfaces und ruft die private Methode quickSort auf.

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);  // Sort the left part
            quickSort(array, pivotIndex + 1, high); // Sort the right part
        }
    }
    // Führt den eigentlichen Quicksort-Algorithmus rekursiv aus.
    // Die Methode ruft sich selbst auf, um die linken und rechten Teile des Arrays zu sortieren.

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
    // Teilt das Array um das Pivot-Element.
    // Elemente kleiner als der Pivot-Wert werden links und größere rechts vom Pivot angeordnet.
    // Der Pivot wird dann in die richtige Position gebracht.

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        System.out.println("QuickSort");
        int[] liste = {6, 2, 1, 3, 7, 8, 5, 9, 4, 5};

        System.out.println("Before Sort");
        for (int i = 0; i < liste.length; i++) {
            System.out.print(liste[i] + " | ");
        }

        System.out.println("\nAfter Sort");
        liste = quickSort.sort(liste);
        for (int i = 0; i < liste.length; i++) {
            System.out.print(liste[i] + " | ");
        }
    }
    //Diese testet die Implementierung von QuickSort, indem sie ein Array vor und nach der Sortierung ausgibt.
}