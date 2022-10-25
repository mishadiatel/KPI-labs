package com.company.l5;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private Node head;
    private class Node {
        private E e;
        private Node next;
        public Node(E e) {
            this.e = e;
            this.next = null;
        }
    }
    public boolean isEmpty() {
         if(this.head == null) return true;
         return false;
    }
    public int size() {
        if (isEmpty()) return 0;
        int size = 1;
        Node thisnode = this.head;
        while (thisnode.next != null) {
            size++;
            thisnode = thisnode.next;
        }
        return size;
    }
    public void add(E element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }
    public E get(int n) {
        int i = 0;
        Node cur = head;
        while (cur != null) {
            if (i == n) return cur.e;
            cur = cur.next;
            i++;
        }
        throw new IndexOutOfBoundsException("Size is less than index");
    }
    public void print() {
        if (isEmpty()) {
            System.out.println("The List is empty.");
        } else {

            Node cur = this.head;
            while (cur != null) {
                System.out.print(cur.e + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
    public boolean remove(E key) {
        boolean isFound = false;
        if(isEmpty()) {
            throw new NoSuchElementException("List is Empty!!");
        }
        if(head.e == key) {
            head = head.next;
            return true;
        }
        Node currentNode = head;
        Node previousNode = null;
        while(currentNode !=null) {
            if(currentNode.e == key) {
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
    public boolean replace(E element, int index) {
        Node cursor = head;
        Node prev = null;
        while (cursor != null && index >= 0) {
            index--;
            prev = cursor;
            cursor = cursor.next;
        }
        if (index > 0) return false;
        if (prev != null)
            prev.e = element;
        return true;
    }
}
