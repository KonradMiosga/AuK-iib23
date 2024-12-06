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
public class HashingTest {
    private Hashing hashing;

    @Before
    public void before() {
        hashing = new Hashing(10);
    }

    @After
    public void after() {
        hashing = null;
    }

    @Test
    @Parameters({
            "apple-peach-lemon-grape,         apple       ,true ",
            "banana-orange-pineapple-pear,    kiwi        ,false",
            "car-dog-elephant-frog,           frog        ,true ",
            "cat-bat-hat,                     rat         ,false",
            "one-two-three,                   two         ,true ",
            "red-blue-green-yellow,           blue        ,true",
            "sun-moon-star,                   cloud       ,false"
    })
    public void testHashingWithWords(String inputWords, String targetWord, boolean expectedBool) {
        String[] inputStrings = inputWords.split("-");
        for (String word : inputStrings) {
            hashing.insert(word);
        }
        Assert.assertEquals(expectedBool, hashing.search(targetWord));
    }
}