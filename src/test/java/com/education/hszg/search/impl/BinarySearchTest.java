package com.education.hszg.search.impl;

import com.education.hszg.search.api.IntSearcher;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(JUnitParamsRunner.class)
public class BinarySearchTest {
    IntSearcher binarySearch;
    @Before
    public void before(){
        binarySearch = new LinearSearch();
    }

    @After
    public void after(){
        binarySearch = null;
    }

    @Test
    @Parameters({
            "1-2-3-4-5,         3       , true",
            "1-2-3-4-5,         6       , false",
            "5-4-3-2-1          ,1      , true",
            "10-20-30-40-50     ,40     , true",
            "12-20-30-40-50     ,23     , false",
            "0-0-0-0-0          ,0      , true"
    })
    public void testBinarySearch(String inputNumbers, int target, boolean expectedBool){
        int[] inputInts = Arrays.stream(inputNumbers.split("-")).mapToInt(Integer::parseInt).toArray();
        binarySearch.search(inputInts, target);
        Assert.assertEquals(expectedBool, binarySearch.search(inputInts, target));
    }
}

