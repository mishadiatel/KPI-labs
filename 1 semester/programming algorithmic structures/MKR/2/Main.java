package com.company;

public class Main {
    public static void main(String[] args) {
        double x = 0.8;
        int kmin = 1;
        int kmax = 6;
        int nek = 4;
        double y  = resultat(x, kmin, kmax, nek);
        System.out.printf("При x = %.1f, k = %d, k-->%d, k ≠ %d \nРезультат:y = %.4f", x, kmin, kmax, nek, y);
    }
    public static double resultat(double x, int kmin, int kmax, int nek) {
        double y = 0;
        for (int k = kmin; k <= kmax; k++) {
            if(k != nek) {
                y += faktorial(k - 1) / (Math.pow((x + 2), k));
            }
        }
        return y;
    }
    public static int faktorial(int f) {
        int result = 1;
        int i = 1;
        while (i <= f) {
            result = result * i;
            i++;
        }
        return result;
    }
}

