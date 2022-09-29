package com.company;
import static java.lang.Math.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double xmin = -2;
        double xmax = 5;
        double h = 0.2;
        Task1(xmin, xmax, h);
        System.out.println("___________Task2____________");
        int[] p = {2, 5, 7, 23, 11, 1, 9, 15, 18, 20};
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.printf("    max(|a1-a2|, |a2-a3|...) =  %d\n", Task2(p));
        int[] b = {30, 25, 32, 7, 19, 5, 1, 54, 6, 7};
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.printf("    max(|a1-a2|, |a2-a3|...) =  %d", Task2(b));
        System.out.println();
        System.out.println("_______________Task3_______________");
        int kmin = 1;
        int kmax = 7;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть х1");
        double x1 = sc.nextDouble();
        System.out.println("Введіть х2");
        double x2 = sc.nextDouble();
        System.out.println("Ви ввели: х1 = " + x1 + " x2 = " + x2);
        System.out.println();
        System.out.printf("Сума ряду при х = " + x1 + " : y = %.4f", Task3(x1, kmin, kmax));
        System.out.println();
        System.out.printf("Сума ряду при х = " + x2 + " : y = %.4f", Task3(x2, kmin, kmax));
    }
    static void Task1(double xmin, double xmax, double h) {
        System.out.println("___________Task1___________");
        System.out.print("   x  |");
        System.out.print("   y     |");
        System.out.println("    z    |");
        for (double x = 10*xmin; x <= 10*xmax; x += 10*h) {
            double y = (tan((x / 10) / 3) * sin((x / 10) - 1.2));
            double z = 2.5 * sin((x / 10) / 2);
            System.out.printf("%.1f  | %.4f | %.4f | \n",x/10, y, z);
        }
        System.out.println();
    }
    public static int Task2(int[] p) {
        int[] c = new int[9];
        int max = c[0];
        int i =0;
        while(i<c.length){
            c[i] = abs(p[i]-p[i+1]);
            i++;
        }
        for(i = 0;i<c.length;i++){
            if(c[i]>max){
                max = c[i];
            }
        }
        return max;
    }
    public static double Task3(double x1, int kmin, int kmax) {
        double y = 0;
        for (int k = kmin; k <= kmax; k++) {
            y += Task31((k - 1)) / (pow(2, k) * pow(x1, k - 1));
        }
        return y;
    }
    public static int Task31(int f) {   // метод для отримання факторіалу
        int result = 1;
        int i = 1;
        while (i <= f) {
            result = result * i;
            i++;
        }
        return result;
    }
}