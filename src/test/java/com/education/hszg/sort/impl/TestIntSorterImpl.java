package com.education.hszg.sort.impl;



import junitparams.JUnitParamsRunner;

import junitparams.Parameters;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

import org.junit.runner.RunWith;



import com.education.hszg.sort.api.IntSorter;



import static org.junit.Assert.assertArrayEquals;



@RunWith(JUnitParamsRunner.class)

public class TestIntSorterImpl {



    IntSorter[] mySortingImpls = new IntSorter[6];



    @Before

    public void before() {

        mySortingImpls[0] = new BubbleSort();

        mySortingImpls[1] = new SelectionSort();

        mySortingImpls[2] = new QuickSort();

        mySortingImpls[3] = new MergeSort();

        mySortingImpls[4] = new InsertionSort();

        mySortingImpls[5] = new TreapSort();

    }



    @After

    public void after() {

        mySortingImpls = null;

    }



    @Test

    @Parameters({

            "7, 7",

            "7-7-7-7-7-7, 7-7-7-7-7-7",

            "6-5-4-3-2-1, 1-2-3-4-5-6",

            "4-5-6-2-1-3, 1-2-3-4-5-6",

            "0-0-0-0-1, 0-0-0-0-1"

    })

    public void testSort(String inputNumbers, String outputNumbers) {

        String[] arrayIn = inputNumbers.split("-");

        String[] arrayOut = outputNumbers.split("-");

        int[] intArrayIn = new int[arrayIn.length];

        for (int i = 0; i < arrayIn.length; i++) {

            intArrayIn[i] = Integer.parseInt(arrayIn[i]);

        }

        int[] intArrayOut = new int[arrayOut.length];

        for (int i = 0; i < arrayOut.length; i++) {

            intArrayOut[i] = Integer.parseInt(arrayOut[i]);

        }



        for (int i = 0; i < mySortingImpls.length; i++) {

            assertArrayEquals(intArrayOut, mySortingImpls[i].sort(intArrayIn));

        }

    }

}