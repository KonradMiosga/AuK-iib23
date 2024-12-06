package com.education.hszg.search.impl;

import com.education.hszg.search.api.IntSearcher;

//Attribute:

//key: Der Wert des Knotens.

//height: Die Höhe des Knotens.

//left: Zeiger auf das linke Kind.

//right: Zeiger auf das rechte Kind.

class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }
}

public class AVLTree implements IntSearcher {

    Node root;

    // höhe des knoten
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // max von 2 int
    int max(int a, int b) {
        return Math.max(a, b);
    }

    // rechte rotation
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    //linke rotation
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    //balanz wert
    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    //insert methode
    Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    //such methode
    Node search(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key)
            return search(root.left, key);

        return search(root.right, key);
    }

    @Override
    public boolean search(int[] array, int num) {
        root = null;
        for (int key : array) {
            root = insert(root, key);
        }
        return search(root, num) != null;
    }

    // Main method f
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        int[] array = {10, 20, 30, 40, 50, 25};

        System.out.println("Inserting elements into AVL Tree:");
        for (int num : array) {
            avlTree.root = avlTree.insert(avlTree.root, num);
            System.out.print(num + " ");
        }
        System.out.println("\n");

        int searchKey = 30;
        boolean found = avlTree.search(array, searchKey);
        System.out.println("Searching for " + searchKey + ": " + (found ? "found" : "not found"));

        searchKey = 60;
        found = avlTree.search(array, searchKey);
        System.out.println("Searching for " + searchKey + ": " + (found ? "found" : "not found"));
    }
}