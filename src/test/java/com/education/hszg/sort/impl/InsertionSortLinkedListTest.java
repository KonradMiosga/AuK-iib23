package com.education.hszg.sort.impl;


import com.education.hszg.sort.api.IntSorter;
import com.education.hszg.util.LinkedList;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(JUnitParamsRunner.class)
public class InsertionSortLinkedListTest {
    IntSorter insertionSortLinkedList;

    @Before
    public void before(){
        insertionSortLinkedList = new InsertionSortLinkedList();
    }

    @After
    public void after(){
        insertionSortLinkedList = null;
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
    public void testInsertionSortLinkedListPreviewTest(String inputNums, String expectedNums){
        int[] inputIntegers = Arrays.stream(inputNums.split("-")).mapToInt(Integer::parseInt).toArray();

        int[] expectedIntegers = Arrays.stream(expectedNums.split("-")).mapToInt(Integer::parseInt).toArray();

        Assert.assertArrayEquals(expectedIntegers, insertionSortLinkedList.sort(inputIntegers));

    }
}

