package com.microsoft;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {

        System.out.println (fizzBuzz (15));
        System.out.println (fizzBuzz1 (15));
    }

    static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<> ();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add ("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add ("Fizz");
            } else if (i % 5 == 0) {
                result.add ("Buzz");
            } else {
                result.add (Integer.toString(i));
            }

        }

        return result;
    }

    static List<String> fizzBuzz1(int n) {
        List<String> answer = new ArrayList<>();
        for (int i= 1; i <= n; i++) {
            String current = "";
            if (i % 3 == 0) {
                current = "Fizz";
            }
            if (i % 5 == 0) {
                current += "Buzz";
            }
            if (current.length() == 0) {
                current = String.valueOf(i);
            }
            answer.add(current);
        }
        return answer;
    }
}
