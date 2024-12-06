package com.education.hszg.calc.impl;
import com.education.hszg.calc.api.ArrayMultiplier;

import java.util.Arrays;

public class Karatsuba implements ArrayMultiplier {

    @Override
    public int[] multiply(int[] x, int[] y) {
        if (x.length < 80 || y.length < 80)
            return new SchoolMethod().multiply(x, y);

        int half = (Math.max(x.length, y.length)+1) / 2;
        // [3,5]
        int[] xl = getLowerHalf(half,x);    // [3,5]
        int[] xh = getUpperHalf(half,x);    // []

        // [1,7,8]
        int[] yl = getLowerHalf(half,y);    // [7,8]
        int[] yh = getUpperHalf(half,y);    // [1]

        int[] p1 = multiply(xh, yh);
        int[] p2 = multiply(xl, yl);
        int[] p3 = multiply(myAdd(xh, xl), myAdd(yh, yl));

        int[] p123 = mySub(mySub(p3, p1), p2);
        return myAdd(arrayLeftShift(p1, 2*half), myAdd(arrayLeftShift(p123, half), p2));
    }

    private static int[] getLowerHalf(int half,int[] array) {
        if(array.length <= half)
            return array;
        int[] lowerHalf = new int[half];
        for(int i = array.length-1, j = half-1; j >= 0; i--,j-- ) {
            lowerHalf[j] = array[i];
        }
        return lowerHalf;
    }

    private static int[] getUpperHalf(int half,int[] array) {
        if(array.length <= half)
            return new int[0];
        int[] upperHalf = new int[array.length-half];
        for(int i = array.length-1-half, j = upperHalf.length-1; j >= 0; i--,j-- ) {
            upperHalf[j] = array[i];
        }
        return upperHalf;
    }

    private static int[] trimLeadingZeros(int[] array) {
        int i = 0;

        while (i < array.length && array[i] == 0) {
            i++;
        }

        if (i == array.length)
            return new int[0];

        int[] trimmedArray = new int[array.length - i];
        System.arraycopy(array, i, trimmedArray, 0, trimmedArray.length);
        return trimmedArray;
    }

    private static int[] myAdd(int[] x, int[] y) {

        int[] result = new int[Math.max(x.length, y.length) + 1];
        for (int yIndex = y.length - 1, xIndex = x.length - 1, resultIndex = result.length - 1; resultIndex > 0; yIndex--, xIndex--, resultIndex--) {
            long sum = result[resultIndex];
            if (xIndex >= 0)
                sum += x[xIndex];
            if (yIndex >= 0)
                sum += y[yIndex];

            result[resultIndex] = (int) sum % 10;
            result[resultIndex - 1] = (int) sum / 10;
        }
        return trimLeadingZeros(x);
    }

    private static int[] mySub(int[] x, int[] y) {
        int borrow = 0;
        for(int yIndex = y.length - 1, xIndex = x.length - 1; xIndex >= 0; yIndex--,xIndex--) {
            long diff = x[xIndex];
            diff -= borrow;

            if(yIndex >= 0)
                diff -= y[yIndex];

            if(diff < 0) {
                diff += 10;
                borrow = 1;
            }
            else {
                borrow = 0;
            }
            x[xIndex] = (int)diff;
        }
        return trimLeadingZeros(x);
    }

    public static int[] arrayLeftShift(int[] arr, int shiftCount) {
        int[] newArray  = new int[arr.length + shiftCount];
        for (int i = arr.length-1; i >= 0; i--) {
            newArray[shiftCount+i] = arr[i];
        }
        return newArray;
    }
    public static void main(String[] args) {
        int[] arr = {1,7,8};
        int[] arr2 = {3,5};
        int[] arr3 = new SchoolMethod().multiply(arr, arr2);
        System.out.println(Arrays.toString(arr3));
    }
}