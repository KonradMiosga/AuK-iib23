package com.education.hszg.calc.impl;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(JUnitParamsRunner.class)
public class KaratsubaTest {
    Karatsuba karatsuba;

    @Before
    public void before() {
        karatsuba = new Karatsuba();
    }

    @After
    public void after() {
        karatsuba = null;
    }

    @Test
    @Parameters({
            "0, 1-1-1-1-1, 0-0-0-0-0-0",
            "1-0-0, 2-0, 0-2-0-0-0",
            "0, 0, 0-0",

    })
    public void testKaratsuba(String x, String y, String expectedRes) {
        int[] xArray = Arrays.stream(x.split("-")).mapToInt(Integer::parseInt).toArray();
        int[] yArray = Arrays.stream(y.split("-")).mapToInt(Integer::parseInt).toArray();
        int[] expectedNumbersArray = Arrays.stream(expectedRes.split("-")).mapToInt(Integer::parseInt).toArray();
        Assert.assertArrayEquals(expectedNumbersArray, karatsuba.multiply(xArray, yArray));
    }
}
