package com.company;

public class Main {
    public static void main(String[] args) {
	    String s1 = "zipdfzop";
        System.out.printf("zipZap( %s ) --> %s ", s1, zipZap(s1));
        String s2 = "dpfwzyp";
        System.out.printf("\nzipZap( %s ) --> %s ", s2, zipZap(s2));
        String s3 = "FrzIp";
        System.out.printf("\nzipZap( %s ) --> %s ", s3, zipZap(s3));
    }
    public static String zipZap(String str) {
        if (str.length() < 2){
            return str;
        }
        String result = str.substring(0, 1);
        for (int i=1; i < (str.length()-1) ; i++) {
            if ((str.charAt(i-1) != 'z') || (str.charAt(i+1) != 'p')) {
                result += str.charAt(i);
            }
        }
        result += str.substring(str.length()-1);
        return result;
    }
}
