package com.education.hszg.sort.impl;


import com.education.hszg.util.LinkedListPreview;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(JUnitParamsRunner.class)
public class InsertionSortLinkedListPreviewTest {
    InsertionSortLinkedListPreview insertionSortLinkedListPreview;

    @Before
    public void before(){
        insertionSortLinkedListPreview = new InsertionSortLinkedListPreview();
    }

    @After
    public void after(){
        insertionSortLinkedListPreview = null;
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
        LinkedListPreview lLIn = LinkedListPreview.toLinkedList(Arrays.stream(inputNums.split("-")).mapToInt(Integer::parseInt).toArray());
        lLIn = insertionSortLinkedListPreview.sort(lLIn);
        LinkedListPreview lLExpected = LinkedListPreview.toLinkedList(Arrays.stream(expectedNums.split("-")).mapToInt(Integer::parseInt).toArray());
        int[] inputConverted =  LinkedListPreview.toInt(lLIn);
        int[] expectedConverted = LinkedListPreview.toInt(lLExpected);
        Assert.assertArrayEquals(expectedConverted, inputConverted);
    }
}

