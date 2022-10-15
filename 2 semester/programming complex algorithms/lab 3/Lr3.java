package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Lr3 {
    public static void main(String[] args) {
        System.out.println("Вкажіть розмір масиву: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [][] arr  = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = ThreadLocalRandom.current().nextInt(0,10);
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
        int [][] arr1 = arr.clone();
        int [][] arr2 = arr.clone();
        System.out.println("\nСортований масив (Сортування вибором)");
        long startTime = System.nanoTime();
        selectionSort(arr1);
        long estimatedTime = System.nanoTime() - startTime;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("%d\t", arr1[i][j]);
            }
            System.out.println();
        }
        System.out.printf("\nЧас роботи алгоритму: %d нс.\n", estimatedTime );
        System.out.println("\nСортування вставками(InsertionSort)");
        long startTime2 = System.nanoTime();
        insertionSort(arr2);
        long estimatedTime2 = System.nanoTime() - startTime2;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("%d\t", arr2[i][j]);
            }
            System.out.println();
        }
        System.out.printf("\nЧас роботи алгоритму: %d нс.\n", estimatedTime2 );
    }
    public static void selectionSort(int[][] array){
        for (int k = 0; k < array.length; k++) {
            for (int i = 0; i < array.length; i++) {
                int pos = i;
                int min = array[i][k];
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j][k] < min) {
                        pos = j;
                        min = array[j][k];
                    }
                }
                array[pos][k] = array[i][k];
                array[i][k] = min;
            }
        }

    }
    public static void insertionSort(int[][] array) {
        for (int k = 0; k < array.length; k++) {
            for (int step = 1; step < array.length; step++) {
                int key = array[step][k];
                int j = step - 1;
                while (j >= 0 && key < array[j][k]) {
                    array[j + 1][k] = array[j][k];
                    --j;
                }
                array[j + 1][k] = key;
            }
        }

    }
}