package com.practise.microsoft;

import java.util.Stack;

public class BasicCalculator2 {

    public static void main(String[] args) {

        String string = "3+2*2";

        System.out.println (basicCalculator2 (string));
    }

    static int basicCalculator2(String string){
        int result = 0;
        if(string ==null || string.length () ==0){
            return result;
        }

        Stack<Integer> nums = new Stack<> ();
        int num = 0;
        char lastOperator = '+';

        for( int i=0;i<string.length ();i++){

            char c = string.charAt (i);

            if(Character.isDigit (c)){

                num = num * 10 + c - '0';
            }

            if( c =='+' || c == '-'|| c== '*' || c == '/' || i == string.length ()-1){

                if( lastOperator == '+'){
                    nums.push (num);
                }

                if( lastOperator == '-'){
                    nums.push (-1 * num);
                }

                if(lastOperator == '*'){
                    nums.push (nums.pop () * num);
                }

                if(lastOperator == '/'){
                    nums.push (nums.pop () /num);
                }

                num = 0;
                lastOperator = c;
            }
        }

        while(!nums.isEmpty ()){
            result += nums.pop ();
        }

        return result;
    }
}
