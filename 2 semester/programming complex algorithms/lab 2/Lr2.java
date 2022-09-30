package com.company;

import java.awt.*;
import java.util.Scanner;

public class Lr2 {
    public static void main(String[] args) {
        int j = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть значення n:");
        int n = sc.nextInt();
        long startTime1 = System.nanoTime();
        double s1 = recurs(j, n);
        long estimatedTime1 = System.nanoTime() - startTime1;
        System.out.printf("Результат отриманий з використанням рекурсії: s = %f", s1);
        System.out.printf("\nЧас роботи алгоритму: %d нс.", estimatedTime1);
        long startTime2 = System.nanoTime();
        double s2 = neRecurs(j, n);
        long estimatedTime2 = System.nanoTime() - startTime2;
        System.out.printf("\nРезультат отриманий без використання рекурсії, за допомогою циклу: s = %f", s2);
        System.out.printf("\nЧас роботи алгоритму: %d нс.", estimatedTime2);
    }
    public static double recurs(int j,  int n){
        double s = 0;
        if(j <= n){
            s += Math.pow(j, 2)/Math.pow(Math.E, j) + recurs(j+1, n);
        }
        return s;
    }
    public static double neRecurs(int j, int n){
        double s = 0;
        while (j<=n){
            s += Math.pow(j, 2)/Math.pow(Math.E, j);
            j++;
        }
        return s;
    }
}
