package com.education.hszg.search.impl;

public class Hashing {
    private String[] table;
    private int size;

    public Hashing(int size) {
        this.size = size;
        table = new String[size];
    }

    private int hash(String key) {
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            char currentChar = key.charAt(i);
            int asciiValue = (int) currentChar;
            hashValue = hashValue + asciiValue;
        }
        return hashValue % size;
    }

    public void insert(String key) {
        int index = hash(key);
        while (table[index] != null) {
            index = (index + 1) % size;
        }
        table[index] = key;
    }

    public boolean search(String key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].equals(key)) {
                return true;
            }
            index = (index + 1) % size;
        }
        return false;
    }
}