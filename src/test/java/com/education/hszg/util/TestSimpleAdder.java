package com.education.hszg.util;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TestSimpleAdder {
    SimpleAdder adder;

    @Before
    public void before(){
        adder = new SimpleAdder();
    }

    @After
    public void after(){
        adder = null;
    }

    @Test
    @Parameters({
            "0,0,0",
            "9838,2,9840",
            "-15,15,0",
            "15,15,30"
    })
    public void testAddTwoNumbers(int numA, int numB, int expectedRes){
        assertEquals(expectedRes,adder.addTwoNumbers(numA,numB));
    }
}
