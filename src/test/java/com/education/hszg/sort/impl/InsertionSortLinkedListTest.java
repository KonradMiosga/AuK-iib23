package com.education.hszg.sort.impl;


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
    InsertionSortLinkedList insertionSortLinkedList;

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
        LinkedList lLIn = LinkedList.toLinkedList(Arrays.stream(inputNums.split("-")).mapToInt(Integer::parseInt).toArray());
        lLIn = insertionSortLinkedList.sort(lLIn);
        LinkedList lLExpected = LinkedList.toLinkedList(Arrays.stream(expectedNums.split("-")).mapToInt(Integer::parseInt).toArray());
        int[] inputConverted =  LinkedList.toInt(lLIn);
        int[] expectedConverted = LinkedList.toInt(lLExpected);
        Assert.assertArrayEquals(expectedConverted, inputConverted);
    }
}

