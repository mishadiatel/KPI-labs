package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Lr1 {

    public static void main(String[] args) {
        System.out.println("Вкажіть розмір масиву: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [][] arr  = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = ThreadLocalRandom.current().nextInt(-50,50);
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("\nЗавдання 1:");
        long startTime = System.nanoTime();
        int [][] arr1 = task1(arr);
        long estimatedTime = System.nanoTime() - startTime;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("%d\t", arr1[i][j]);
            }
            System.out.println();
        }
        System.out.printf("\nЧас роботи алгоритму: %d нс.\n", estimatedTime );
        System.out.println("\nЗавдання 2:");
        int [][] arr2 = task2(arr);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("%d\t", arr2[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] task1(int[][] arr) {
        int[][] arr1 = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            int k = 0;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] < 0) k++;
            }
            if (k > arr[0].length / 2) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr1[i][j] = arr[i][arr.length - 1 - j];
                }
            } else {
                for (int j = 0; j < arr[0].length; j++) {
                    arr1[i][j] = arr[i][j];
                }
            }
        }
        return arr1;
    }

    public static int [][] task2(int [][] arr){
        int [][] arr1 = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr1[i][j] = arr[arr.length - 1 - i][j];
            }
        }
        return arr1;
    }
}