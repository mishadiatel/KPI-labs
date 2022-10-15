package com.company.l4;

import java.util.Scanner;

public class Lalala {
    public static void main(String[] args) {
        int arr[][] = new int[10][10];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) (Math.random() * 50);
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }


//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < n; i++) {
//            boolean isSorted = false;
//            while (!isSorted) {
//                isSorted = true;
//                for (int j = 0; j < n - 1; j++) {
//                    if (arr[i][j] > arr[i][j + 1]) {
//                        int temp = arr[i][j];
//                        arr[i][j] = arr[i][j + 1];
//                        arr[i][j + 1] = temp;
//                        isSorted = false;
//                    }
//                }
//            }
//        }
        for (int i = 0; i < arr.length; i++) {
            bubbleSort(arr[i]);
        }
        System.out.println("--------------------");
        System.out.println("Сортований масив");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.print("Вкажіть число  ");
        Scanner scanner = new Scanner(System.in);
        int seek = scanner.nextInt();
        boolean l = false;
        for (int i = 0; i < n; i++) {
            int j = task2(arr[i],seek);
            if (j != -1) {
                System.out.printf("Даний елемент знаходиться в: Рядок %d  Стовпець %d \n", i + 1, j + 1);
                l = true;
            }
        }
        if (!l) {
            System.out.println("Елемента " + seek + " немає в масиві.");
        }
    }
    public static int task2(int [] arr, int seek){
        int startIndex = 0;
        int lastIndex = arr.length-1;
        while (startIndex <= lastIndex){
            int middle = startIndex + (lastIndex-startIndex)/2;
            if(seek < arr[middle]){
                lastIndex = middle-1;
            }else if(seek > arr[middle]){
                startIndex = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }
    public static void bubbleSort(int[] sort_arr){
        for (int i=0;i< sort_arr.length;++i){
            for(int j=0;j< sort_arr.length-i-1; ++j){
                if(sort_arr[j+1]<sort_arr[j]){
                    int swap = sort_arr[j];
                    sort_arr[j] = sort_arr[j+1];
                    sort_arr[j+1] = swap;

                }
            }
        }
    }
}
