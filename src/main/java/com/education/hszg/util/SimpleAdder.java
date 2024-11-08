package com.education.hszg.util;

public class SimpleAdder {
    public int addTwoNumbers(int a, int b){
        return a + b;
    }
    public static void main(String[] args) {
        SimpleAdder simpleAdder = new SimpleAdder();
        int a = 12;
        int b = 14;
        int res = simpleAdder.addTwoNumbers(a, b);
        System.out.println("testing adder : " + a + " + " + b + " = " +res);
    }
}
