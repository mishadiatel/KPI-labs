package com.company;
import java.util.Scanner;

public class Lr22 {
    public static void main(String[] args) {
        double a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть сторони трикутника");
        System.out.println("найбільша сторона:");
        a = sc.nextDouble();
        System.out.println("інші сторони:");
        b = sc.nextDouble();
        c = sc.nextDouble();
        System.out.println("Ви ввели:"+ a + "  " + b + "  " + c);
        System.out.println(task3(a, b, c));
        System.out.println();
        double x0, y0, x1, y1, x01, y01, x11, y11, x02, y02, x12, y12;
        x0 = 2;
        y0 = 2;
        x1 = -4;
        y1 = 0;
        x01 = 8;
        y01 = 9;
        x11 = 12;
        y11 = 1;
        x02 = -3;
        y02 = 0.9;
        x12 = 2;
        y12 = 3;
        System.out.println("З точок А("+ x0 + ";" + y0 + ") і В("+x1 +";" + y1 +")" + task4(x0, y0, x1, y1));
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("З точок А("+ x01 + ";" + y01 + ") і В("+x11 +";" + y11 +")" + task4(x01, y01, x11, y11));
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("З точок А("+ x02 + ";" + y02 + ") і В("+x12 +";" + y12 +")" + task4(x02, y02, x12, y12));
        System.out.println("-----------------------------------------------------------------------");
    }
    public static String task3 (double a, double b, double c){
        String n;
        if(a*a == (b*b) + (c*c) && a < b+c ){
            n = "Цей трикутник прямокутний";
        }else if(a*a > (b*b) + (c*c) && a < b+c ){
            n = "Цей трикутник не прямокутний він тупокутний";
        }else if (a*a < (b*b) + (c*c) && a < b+c ){
            n = "Цей трикутник не прямокутний він гострокутний";
        }else{
            n = "Це не трикутник";
        }
        return n;
    }
    public static String task4 (double x0, double y0, double x1, double y1){
        String g;
        if((x0*x0)+(y0*y0)>(x1*x1)+(y1*y1)){
            g = "Точка В найменш віддалена від початку координат";
        }else if((x0*x0)+(y0*y0)<(x1*x1)+(y1*y1)){
            g = "Точка А найменш віддалена від початку координат";
        }else{
            g = "Точка А знаходиться на такій самій відстані від початку координат як і точка В";
        }
        return g;
    }
}