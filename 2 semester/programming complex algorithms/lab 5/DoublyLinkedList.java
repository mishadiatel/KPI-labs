package com.company.l5;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    private Node head, tail = null;
    class Node{
        E item;
        Node previous;
        Node next;
        public Node(E item) {
            this.item = item;
        }
    }
    public boolean isEmpty() {
        return head == null || tail == null;
    }
    public int size() {
        if (isEmpty()) return 0;
        int size = 1;
        Node current = this.head;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    public void add(E item) {

        Node newNode = new Node(item);
        if(head == null) {
            head = tail = newNode;
            head.previous = null;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        tail.next = null;
    }
    public E get(int N) {
        int i = 0;
        Node current = head;
        while (current != null) {
            if (i == N) return current.item;
            current = current.next;
            i++;
        }
        throw new NoSuchElementException("Size is less than index");
    }
    public boolean remove(E key) {
        boolean isFound = false;
        if(isEmpty()) {
            throw new NoSuchElementException("List is Empty!!");
        }
        if(head.item == key) {
            head = head.next;
            return true;
        }
        Node currentNode = head;
        Node previousNode = null;
        while(currentNode !=null) {
            if(currentNode.item == key) {
                isFound = true;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if(currentNode == null) {
            return isFound;
        }
        currentNode = previousNode.next;
        previousNode.next = currentNode.next;
        currentNode.next = null;
        return isFound;
    }
    public void removeAll() {
        Node nextNode, iterator = head;
        while(iterator != null) {
            nextNode = iterator.next;
            iterator.next = null;
            iterator = nextNode;
        }
        head = null;
    }
    public void print() {
        Node current = head;
        if(head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        while(current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }
}