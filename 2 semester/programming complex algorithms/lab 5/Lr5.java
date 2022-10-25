package com.company.l5;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Lr5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Вкажіть кількість елементів однозв'язного списку: ");
        int kilkist = sc.nextInt();
        SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
        for (int i = 0; i < kilkist; i++) {
            sList.add(ThreadLocalRandom.current().nextInt(0, 50));
        }
        sList.print();
        System.out.print("Вкажіть ключ : ");
        int key = sc.nextInt();
        taskDeleteForSinglyList(sList, key);
        System.out.print("Вкажіть кількість елементів двозв'язного списку: ");
        int kilkist1 = sc.nextInt();
        DoublyLinkedList<Integer> dList = new DoublyLinkedList<>();
        for (int i = 0; i < kilkist1; i++) {
            dList.add(ThreadLocalRandom.current().nextInt(0,50));
        }
        dList.print();
        System.out.print("Вкажіть ключ : ");
        int key1 = sc.nextInt();
        taskDeleteForDoublyList(dList, key1);
        System.out.println("__________Завдання згідно варіанту_________");
        System.out.println("Завдання для однозв'язного списку");
        System.out.print("Вкажіть натуральне число n: ");
        int n = sc.nextInt();
        SinglyLinkedList<Integer> singly = new SinglyLinkedList<>();
        for (int i = 0; i < n; i++) {
            singly.add(ThreadLocalRandom.current().nextInt(0, 50));
        }
        singly.print();
        taskForSingleList(singly);
        System.out.println("Завдання для двозв'язного списку");
        System.out.print("Вкажіть натуральне число n: ");
        int n1 = sc.nextInt();
        DoublyLinkedList<Integer> doubly = new DoublyLinkedList<>();
        for (int i = 0; i < n1; i++) {
            doubly.add(ThreadLocalRandom.current().nextInt(0, 50));
        }
        doubly.print();
        taskForDoublyList(doubly);
    }
    public static void taskDeleteForSinglyList(SinglyLinkedList<Integer> lst, int key){
        boolean isKey = false;
        for (int i = 0; i < lst.size(); i++) {
            if(lst.get(i) == key){
                isKey = true;
                int q = lst.get(i+1);
                int w = lst.get(i-1);
                lst.replace(q, i-1);
                lst.replace(w, i+1);
                lst.print();
            }
        }
        if(isKey) {
            lst.remove(key);
            lst.print();
        }else System.out.println("Не знайдено елемента із вказаним ключем");
    }
    public static void taskDeleteForDoublyList(DoublyLinkedList<Integer> lst, int key){
        boolean isKey = false;
        for (int i = 0; i < lst.size(); i++) {
            if(lst.get(i) == key) isKey = true;
        }
        if(isKey) {
            lst.remove(key);
            lst.print();
        }else System.out.println("Не знайдено елемента із вказаним ключем");
    }
    public static void taskForSingleList(SinglyLinkedList<Integer> list){
        boolean isSorted = false;
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        int t = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= t) t = arr[i];
            if(t == arr[arr.length-1]) isSorted = true;
        }
        if(isSorted){
            System.out.println("Послідовність впорядкована так що а(1) <= a(2) <= ... <= a(n)");
            list.print();
        }else{
            list.removeAll();
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[arr.length-1-i]);
            }
            System.out.println("Послідовність a(n), ... , a(1)");
            list.print();
        }
    }
    public static void taskForDoublyList(DoublyLinkedList<Integer> list){
        boolean isSorted = false;
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        int t = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= t) t = arr[i];
            if(t == arr[arr.length-1]) isSorted = true;
        }
        if(isSorted){
            System.out.println("Послідовність впорядкована так що а(1) <= a(2) <= ... <= a(n)");
        }else{
            list.removeAll();
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[arr.length-1-i]);
            }
            System.out.println("Послідовність a(n), ... , a(1)");
        }
        list.print();
    }
}
