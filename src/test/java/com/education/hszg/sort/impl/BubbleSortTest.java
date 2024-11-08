package com.education.hszg.sort.impl;

import com.education.hszg.sort.api.IntSorter;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(JUnitParamsRunner.class)
public class BubbleSortTest {
    IntSorter bubbleSort;
    @Before
    public void before(){
        bubbleSort = new BubbleSort();
    }

    @After
    public void after(){
        bubbleSort = null;
    }

    @Test
    @Parameters({
            "7,              7",
            "7-7-7-7-7-7-7-7,7-7-7-7-7-7-7-7",
            "1-2-3-4,        1-2-3-4",
            "9-8-7-6-5,      5-6-7-8-9",
            "0-0-0-0-1,      0-0-0-0-1",
            "1-0-0-0-0,      0-0-0-0-1"
    })
    public void testBubbleSort(String inputNumber, String outputNumber){
        int[] inputInts = Arrays.stream(inputNumber.split("-")).mapToInt(Integer::parseInt).toArray();
        int[] outputInts = Arrays.stream(outputNumber.split("-")).mapToInt(Integer::parseInt).toArray();
        Assert.assertArrayEquals(outputInts, bubbleSort.sort(inputInts));
    }
}
