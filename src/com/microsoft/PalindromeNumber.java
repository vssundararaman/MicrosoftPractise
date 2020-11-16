package com.microsoft;

public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println (validPalindromeNumber (123));
    }

    static boolean validPalindromeNumber(int x){
        int result = 0;
        int original = x;

        while(x > 0){
            result = result * 10 + (x%10);
            x /= 10;
        }

        return original == result;
    }
}
