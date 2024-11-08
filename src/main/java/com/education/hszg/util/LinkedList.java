package com.education.hszg.util;

public class LinkedList {
    public Node head;

    /**
     * inner class for the Nodes
     */
    public static class Node{
        public int value;
        public Node next;
        Node(int value){
            this.value = value;
            next = null;
        }
    }
    /**
     * appends a new value at the end of the Linked List
     * @param value the value that will be appended
     */
    public void append(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    /**
     * amount of Nodes in LinkedList
     * @return amount
     */
    public int size(){
        int i = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            i++;
        }
        return i;
    }

    /**
     * function to use an int[] and make it into a LinkedList based on position
     * @param array int[] to use
     * @return LinkedList of the array
     */
    public static LinkedList toLinkedList(int[] array){
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < array.length; i++){
            linkedList.append(array[i]);
        }
        return linkedList;
    }

    /**
     * turns a LinkedList into an int[] with head as int[0]
     * @param linkedList the LinkedList to use
     * @return returns a new int[]
     */
    public static int[] toInt(LinkedList linkedList){
        int[] array = new int[linkedList.size()];
        Node curr = linkedList.head;
        for (int i = 0; i < linkedList.size() - 1; i++) {
            array[i] = curr.value;
            curr = curr.next;
        }
        return array;
    }

}
