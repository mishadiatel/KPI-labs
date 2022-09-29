package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class RgrTr12Diat {
    public static void main(String[] args) {
        double [][] pmat = {
                {10, -1, -2, -7, -4, -0.8},
                {-8, -1, -3, -1, 4, -82.5},
                {10, -9, -4, -2, 5, 69.6},
                {-1, 6, -2, 4, -1, 11.2},
                {-6, 2, 5, 7, 2, 43.9}};
        System.out.println("___________________Завдання 1___________________");
        System.out.println("Початкова матриця :");
        task13(pmat);
        System.out.println("Трикутна матриця:");
        double[][] f = task11(pmat);
        task13(f);
        System.out.println("Вектор результатів:");
        double [][] c = task12(f);
        task13(c);
        System.out.println("___________________Завдання 2___________________");
        System.out.println("Введіть перше число");
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> dis1, dis2, dis3;
        int a1 = sc.nextInt();
        System.out.println("Ви ввели " + a1);
        System.out.print("Цифри кратні 3 :");
        dis1 = task2(a1);
        for (int i = 0; i < dis1.size(); i++) {
            System.out.printf(dis1.get(i) + " ");
        }
        System.out.print("\n\nВведіть друге число");
        int a2 = sc.nextInt();
        System.out.println("Ви ввели " + a2);
        System.out.print("Цифри кратні 3 :");
        dis2 = task2(a2);
        for (int i = 0; i < dis2.size(); i++) {
            System.out.printf(dis2.get(i) + " ");
        }
        System.out.println("\n\nВведіть третє число");
        int a3 = sc.nextInt();
        System.out.println("Ви ввели " + a3);
        System.out.print("Цифри кратні 3 :");
        dis3 = task2(a3);
        for (int i = 0; i < dis3.size(); i++) {
            System.out.printf(dis3.get(i) + " ");
        }
    }
    public static double [][] task11(double [][] pmat){
        for(int k = 1; k<5; k++){
            for(int j = k; j<5; j++){
                double m = pmat[j][k-1] / pmat[k-1][k-1];
                int i = 0;
                while(i<5+1){
                    pmat[j][i] = pmat[j][i] - m * pmat[k-1][i];
                    i++;
                }
            }
        }
        return pmat;
    }
    public static double[][] task12(double [][] f){
        double[][] x = new double[1][5];
        for(int i = 4; i>=0; i--){
            x[0][i] = f[i][5] / f[i][i];
            int o = 4;
            while(o>i){
                x[0][i] = x[0][i] - f[i][o] * x[0][o] / f[i][i];
                o--;
            }
        }
        return x;
    }
    static void task13(double [][] pmat){
        for (int i = 0; i < pmat.length; i++){
            for (int j = 0; j < pmat[i].length; j++)
                if(pmat[i][j]%1 == 0) {
                    System.out.printf("%.0f\t\t ", pmat[i][j]);
                }else {
                    System.out.printf("%.3f\t ", pmat[i][j]);
                }
            System.out.println();
        }
    }
    public static ArrayList<Character> task2(int a){
        String string = String.valueOf(a);
        char[] array = string.toCharArray();
        ArrayList <Character> arr = new ArrayList();
        for (int i = 0; i<array.length; i++) {
            if ((array[i]) % 3 == 0) {
                arr.add(array[i]);
            }
        }
        return arr;
    }
}