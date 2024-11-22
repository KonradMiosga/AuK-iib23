package com.education.hszg.util;

import java.util.Random;

public class TreapNode {

    private int data;
    private int priority;
    private TreapNode left, right;

    public TreapNode(int data) {
        this.data = data;
        this.priority = new Random().nextInt();
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TreapNode getLeft() {
        return left;
    }

    public void setLeft(TreapNode left) {
        this.left = left;
    }

    public TreapNode getRight() {
        return right;
    }

    public void setRight(TreapNode right) {
        this.right = right;
    }
}
