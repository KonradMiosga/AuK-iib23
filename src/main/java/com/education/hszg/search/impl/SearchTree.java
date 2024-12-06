package com.education.hszg.search.impl;

import com.education.hszg.search.api.IntSearcher;

public class SearchTree implements IntSearcher {

    // Innere Klasse TreeNode
    // macht den code einfacher weil kein getter und setter benötigt werden
    // capselung ist nicht notwendig, da die Klasse nur innerhalb von SearchTree verwendet wird
    private class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int value) {
            this.value = value;
        }
    }

    private TreeNode root;

    @Override
    public boolean search(int[] intArray, int element) {
        insert(intArray);
        return member(element);
    }

    // fügt ein Element in den Baum ein
    void insert(int e){
        root = insertHelper(e, root);
        return;
    }
    // fügt Array in den Baum ein
    void insert(int[] arr){
        for(int e : arr) root = insertHelper(e, root);
        return;
    }
    TreeNode insertHelper(int e, TreeNode node){
        if(node == null)            return new TreeNode(e);
        if(e < node.value)          node.left = insertHelper(e, node.left);
        else if(e > node.value)     node.right = insertHelper(e, node.right);
        return node;
    }

    // entfernt ein Element aus dem Baum
    void remove(int e) {
        root = removeHelper(e, root);
    }
    TreeNode removeHelper(int e, TreeNode node) {
        if (node == null)           return null;                                //nicht gefunden
        if (e < node.value)         node.left = removeHelper(e, node.left);     // e < Knoten
        else if (e > node.value)    node.right = removeHelper(e, node.right);   // e > Knoten
        else {                                                                  // e = Knoten
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            TreeNode minNode = findMin(node.right);
            node.value = minNode.value;
            node.right = removeHelper(minNode.value, node.right);
        }
        return node;
    }
    TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // prüft ob das Element e im Baum vorhanden ist
    boolean member(int e){
        return memberHelper(e, root);
    }
    boolean memberHelper(int e, TreeNode node){
        if(node == null) return false;
        if(e == node.value) return true;
        if(e < node.value) return memberHelper(e, node.left);
        if(e > node.value) return memberHelper(e, node.right);
        return false;
    }

    /*
    void printTree() {
        printTreeHelper(root, 0);
    }
    void printTreeHelper(TreeNode node, int depth) {
        if (node == null) return;
        printTreeHelper(node.right, depth + 1);
        System.out.println("     ".repeat(depth) + node.value);
        printTreeHelper(node.left, depth + 1);
    }
    */

    public static void main(String[] args) {
        SearchTree t = new SearchTree();
        t.insert(new int[]{111,23,4,645,65,324,234});
        System.out.println(t.member(111));
    }

}