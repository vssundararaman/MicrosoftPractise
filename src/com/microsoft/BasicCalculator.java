package com.microsoft;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        String string = "(1+(4+5+2)-3)+(6+8)";
        System.out.println (basicCalculator (string));

    }

    static int basicCalculator(String string) {
        int sign = 1;
        int sum = 0;
        Stack<Integer> stack = new Stack<> ();

        for (int i = 0; i < string.length (); i++) {

            if (string.charAt (i) >= '0' && string.charAt (i) <= '9') {
                int num = 0;
                while (i < string.length () && string.charAt (i) >= '0' && string.charAt (i) <='9' ){
                    num = num * 10 + string.charAt (i) - '0';
                    i++;
                }
                sum += num * sign;
                i--;
            } else if (string.charAt (i) == '+') {
                sign = 1;
            } else if (string.charAt (i) == '-') {
                sign = -1;
            } else if (string.charAt (i) == '(') {
                stack.push (sum);
                stack.push (sign);
                sum = 0;
                sign = 1;
            } else if (string.charAt (i) == ')') {
                sum = stack.pop () * sum;
                sum += stack.pop ();
            }
        }
        return sum;
    }
}

