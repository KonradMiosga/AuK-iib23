package com.education.hszg.sort.impl;

import com.education.hszg.sort.api.IntSorter;
import com.education.hszg.util.TreapNode;

import java.util.ArrayList;
import java.util.List;

public class TreapSort implements IntSorter {
    private TreapNode root;

    public TreapSort() {
        root = null;
    }

    private void insert(int data) {
        root = insertRec(root, data);
    }


    private TreapNode insertRec(TreapNode parent, int data) {

        // first node
        if (parent == null) return new TreapNode(data);

        // binary Tree attribute
        if (data < parent.getData()) {
            parent.setLeft(insertRec(parent.getLeft(), data));
        } else {
            parent.setRight(insertRec(parent.getRight(), data));
        }

        // heap attribute
        if (parent.getLeft() != null && parent.getLeft().getPriority() > parent.getPriority()) {
            parent = rightRotate(parent);
        } else if (parent.getRight() != null && parent.getRight().getPriority() > parent.getPriority()) {
            parent = leftRotate(parent);
        }

        return parent;
    }


    // Helper function for right rotation
    private TreapNode rightRotate(TreapNode currentNode) {
        TreapNode newParent = currentNode.getLeft();

        TreapNode rightSubtreeOfNewParent = newParent.getRight();

        // perform rotation
        newParent.setRight(currentNode);
        currentNode.setLeft(rightSubtreeOfNewParent);

        return newParent;
    }

    // Helper function for left rotation
    private TreapNode leftRotate(TreapNode currentNode) {
        TreapNode newParent = currentNode.getRight();

        TreapNode leftSubtreeOfNewParent = newParent.getLeft();

        newParent.setLeft(currentNode);
        currentNode.setRight(leftSubtreeOfNewParent);

        return newParent;
    }

    private List<Integer> inOrderRec(TreapNode parent, List<Integer> list) {
        if (parent != null) {
            inOrderRec(parent.getLeft(), list);
            list.add(parent.getData());
            inOrderRec(parent.getRight(), list);
        }
        return list;
    }

    public List<Integer> inOrder() {
        List<Integer> list = new ArrayList<>();
        return inOrderRec(root, list);
    }

    @Override
    public int[] sort(int[] intArray) {
        TreapSort treapSort2 = new TreapSort();

        for (int j : intArray) {
            treapSort2.insert(j);
        }

        int[] sortedNumbersArray = new int[intArray.length];
        List<Integer> sortedTreapList = treapSort2.inOrder();

        for (int i = 0; i < sortedNumbersArray.length; i++) {
            sortedNumbersArray[i] = sortedTreapList.get(i);
        }

        return sortedNumbersArray;

    }


}