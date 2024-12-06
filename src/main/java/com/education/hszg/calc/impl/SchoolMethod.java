package com.education.hszg.calc.impl;

import com.education.hszg.calc.api.ArrayMultiplier;

import java.util.Arrays;

public class SchoolMethod implements ArrayMultiplier {
    @Override
    public int[] multiply(int[] x, int[] y) {
        int[] result = new int[x.length + y.length];
        int xStart = x.length - 1;
        int yStart = y.length - 1;
        for (int xIndex = xStart; xIndex >= 0; xIndex--) {
            int carry = 0;
            for (int yIndex = yStart, offset = yStart + 1 + xIndex; yIndex >= 0; yIndex--, offset --) {
                int sum = x[xIndex] * y[yIndex] + result[offset] + carry;
                result[offset] = sum % 10;
                carry = sum / 10;
            }
            result[xIndex] = carry;
        }
        return result;
    }

    /**
     * to test in command line
     * base 10 so each position of a, b and res should be 0 - 9
     * @param args nothing
     */
    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {2,0};
        SchoolMethod schoolMethod = new SchoolMethod();
        int[] res = schoolMethod.multiply(a,b);
        System.out.println(Arrays.toString(res));
    }
}
