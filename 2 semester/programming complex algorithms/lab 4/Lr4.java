package com.company.l4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Lr4 {
    public static void main(String[] args) {
        System.out.println("Вкажіть розмір масиву: ");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = ThreadLocalRandom.current().nextInt(0, 50);
                 System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("\nЗавдання №1: Пошук з бар'єром");
        System.out.println("\nВкажіть число від 0 до 50");
        int elementToSearch1 = sc.nextInt();
        //long startTime1 = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            int j = barrierSearch(elementToSearch1, arr[i]);
            if(j != -1) {
                System.out.printf("Елемент знайдено у рядку %d, стовпець %d\n", i + 1, j + 1);
            }
            else System.out.printf("У рядку %d елемент не знайдено\n", i+1);
        }
        //long estimatedTime1 = System.nanoTime() - startTime1;
        //System.out.printf("\nЧас роботи алгоритму: %d нс.\n", estimatedTime1 );
        System.out.println("\nЗавдання №2: Двійковий пошук");
        System.out.println("Сортований масив:");
        for (int i = 0; i < arr.length; i++) {
            Arrays.sort(arr[i]);
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("\nВкажіть число від 0 до 50");
        int elementToSearch2 = sc.nextInt();
        //long startTime2 = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            int j = binarySearch(elementToSearch2, arr[i]);
            if(j != -1) {
                System.out.printf("Елемент знайдено у рядку %d, стовпець %d\n", i + 1, j + 1);
            }
            else System.out.printf("У рядку %d елемент не знайдено\n", i+1);
        }
        //long estimatedTime2 = System.nanoTime() - startTime2;
        //System.out.printf("\nЧас роботи алгоритму: %d нс.\n", estimatedTime2 );

    }

    public static int barrierSearch(int key, int[] arr) {
        int result;
        int last = arr[arr.length - 1];
        arr[arr.length - 1] = key;

        for (result = 0; arr[result] != key; result++);
        arr[arr.length - 1] = last;
        if (result != arr.length - 1 || key == last)
            return result;
        return -1;
    }

    public static int binarySearch(int elementToSearch, int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        while(first <= last) {
            int middleIndex = (first + last) / 2;

            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            }

            else if (arr[middleIndex] < elementToSearch)
                first = middleIndex + 1;

            else if (arr[middleIndex] > elementToSearch)
                last = middleIndex - 1;

        }
        return -1;
    }
}
