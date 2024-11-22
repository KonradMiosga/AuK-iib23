package com.education.hszg.sort.impl;

import com.education.hszg.sort.api.IntSorter;
import com.education.hszg.util.LinkedList;
import com.education.hszg.util.Node;

public class InsertionSortLinkedList implements IntSorter {

    /**
     * Sorts the linked list using insertion sort and returns the sorted list.
     * @return the sorted LinkedList
     */
    public LinkedList sortLinkedList(LinkedList linkedList) {
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
            Node temp = sorted;
            while (temp.next != null && temp.next.value < newNode.value) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return sorted;
    }

    @Override
    public int[] sort(int[] numbers) {
        LinkedList linkedList = LinkedList.toLinkedList(numbers);
        linkedList = sortLinkedList(linkedList);
        return LinkedList.toInt(linkedList);
    }
}
