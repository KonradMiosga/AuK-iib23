package com.education.hszg.sort.impl;

import com.education.hszg.util.LinkedListPreview;
import com.education.hszg.util.LinkedListPreview.*;

public class InsertionSortLinkedListPreview{

    /**
     * Sorts the linked list using insertion sort and returns the sorted list.
     * @return the sorted LinkedList
     */
    public LinkedListPreview sort(LinkedListPreview linkedListPreview) {
        if (linkedListPreview.head == null || linkedListPreview.head.next == null) {
            return linkedListPreview;
        }

        Node sorted = null;

        Node current = linkedListPreview.head;
        while (current != null) {
            Node next = current.next;
            sorted = sortedInsert(sorted, current);
            current = next;
        }

        linkedListPreview.head = sorted;
        return linkedListPreview;
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
