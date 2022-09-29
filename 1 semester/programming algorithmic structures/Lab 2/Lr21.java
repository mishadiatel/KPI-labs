package com.company;
import static java.lang.Math.*;

public class Lr21 {
    public static void main(String[] args) {
        double a, b, x1,x2, x3, y;
        a = 1.5;
        b = 0.7;
        x1 = -2.3;
        x2 = 0.6;
        x3 = 4.8;
        System.out.println("--------------------------------завдання 1------------------------------------");
        System.out.printf("В завданні з таблиці 1 при х = " + x1 + "   результат: y =" + "%.4f", task1(a,b,x1));
        System.out.println();
        System.out.printf("В завданні з таблиці 1 при х = " + x2 + "   результат: y =" + "%.4f", task1(a,b,x2));
        System.out.println();
        System.out.printf("В завданні з таблиці 1 при х = " + x3 + "   результат: y =" + "%.4f", task1(a,b,x3));
        System.out.println();

        double a1, b1, c1, a2, b2, c2, a3, b3, c3;
        a1 = 3.2;
        b1 = -0.7;
        c1 = 2.2;
        a2 = 10.5;
        b2 = -2.5;
        c2 = 5.6;
        a3 = 5.4;
        b3 = 3;
        c3 = 2.6;
        System.out.println("------------------------------завдання2----------------------------------------");
        System.out.printf("В завданні з таблиці 2 при х = " + x1 +" a = " + a1+ " b =" + b1 +" c =" + c1 + " результат: y =" + "%.4f", task2(a1, b1, c1, x1));
        System.out.println();
        System.out.printf("В завданні з таблиці 2 при х = " + x2 +" a = " + a1+ " b =" + b1 +" c =" + c1 + " результат: y =" + "%.4f", task2(a1, b1, c1, x2));
        System.out.println();
        System.out.printf("В завданні з таблиці 2 при х = " + x3 +" a = " + a1+ " b =" + b1 +" c =" + c1 + " результат: y =" + "%.4f", task2(a1, b1, c1, x3));
        System.out.println();
        System.out.printf("В завданні з таблиці 2 при х = " + x1 +" a = " + a2+ " b =" + b2 +" c =" + c2 + " результат: y =" + "%.4f", task2(a2, b2, c2, x1));
        System.out.println();
        System.out.printf("В завданні з таблиці 2 при х = " + x2 +" a = " + a2+ " b =" + b2 +" c =" + c2 + " результат: y =" + "%.4f", task2(a2, b2, c2, x2));
        System.out.println();
        System.out.printf("В завданні з таблиці 2 при х = " + x3 +" a = " + a2+ " b =" + b2 +" c =" + c2 + " результат: y =" + "%.4f", task2(a2, b2, c2, x3));
        System.out.println();
        System.out.printf("В завданні з таблиці 2 при х = " + x1 +" a = " + a3+ " b =" + b3 +" c =" + c3 + " результат: y =" + "%.4f", task2(a3, b3, c3, x1));
        System.out.println();
        System.out.printf("В завданні з таблиці 2 при х = " + x2 +" a = " + a3+ " b =" + b3 +" c =" + c3 + " результат: y =" + "%.4f", task2(a3, b3, c3, x2));
        System.out.println();
        System.out.printf("В завданні з таблиці 2 при х = " + x3 +" a = " + a3+ " b =" + b3 +" c =" + c3 + " результат: y =" + "%.4f", task2(a3, b3, c3, x3));
    }
    public static double task1 (double a, double b, double x){
        double z = tan(abs(b*x));
        double d;
        if(x<=a){
            d = a*pow(cos(x), 2) + b*pow(sin(z*x), 2);
        }else if(x>a && x<=4.5*b){
            d = a*tan(pow(sin(b*x), 2)+z);
        }else {
            d = log((a*x)-b) + z*z;
        }
        return d;
    }
    public static double task2 (double a1, double b1, double c1, double x){
        double k;
        if(abs(1-(x*x))==a1+c1){
            k = x*pow(E,a1) + pow(E,abs(b1*c1));
        }else if(abs(1-(x*x))>a1+c1){
            k = pow(sin(a1*x), 2) + cos(b1*c1);
        }else {
            k = sqrt(a1*pow(b1, 4) + pow((c1*x*x),1.0/5.0));
        }
        return k;
    }
}