package com.education.hszg.sort.impl;

import com.education.hszg.util.LinkedList;
import com.education.hszg.util.LinkedList.*;

public class InsertionSortLinkedList {

    /**
     * Sorts the linked list using insertion sort and returns the sorted list.
     * @return the sorted LinkedList
     */
    public LinkedList sort(LinkedList linkedList) {
        if (linkedList.head == null || linkedList.head.next == null) {
            return linkedList;
        }

        Node sorted = null;

        Node current = linkedList.head;
        while (current != null) {
            Node next = current.next;
            sorted = sortedInsert(sorted, current);
            current = next;
        }

        linkedList.head = sorted;
        return linkedList;
    }

    /**
     * Helper method to insert a node into the sorted part of the list.
     * @param sorted The head of the sorted part of the list.
     * @param newNode The node to insert.
     * @return The new head of the sorted list.
     */
    private Node sortedInsert(Node sorted, Node newNode) {
        if (sorted == null || newNode.value < sorted.value) {
            newNode.next = sorted;
            return newNode;
        } else {
            Node current = sorted;
            while (current.next != null && current.next.value < newNode.value) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        return sorted;
    }
}
