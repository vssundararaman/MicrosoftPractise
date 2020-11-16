package com.FB;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args)
    {
        String str = "";
        System.out.println (isValidParenthesis (str));
        str = "()(";
        System.out.println (isValidParenthesis (str));
        str = "(())";
        System.out.println (isValidParenthesis (str));
    }
    static boolean isValidParenthesis(String string){
        if(string == null || string.length ()==0){
            return false;
        }

        Stack<Character> stack = new Stack<> ();

        for(int i=0;i<string.length ();i++){
            if(string.charAt (i) == '{' || string.charAt(i)== '(' || string.charAt(i) =='['){
                stack.add (string.charAt (i));
            }else if(!stack.isEmpty () && ((string.charAt (i)==')')
                    || string.charAt (i)=='}' || string.charAt (i)==']')){
                stack.pop ();
            }else{
                stack.add (string.charAt (i));
            }
        }

        if(stack.isEmpty ()){
            return true;
        }else{
            return false;
        }
    }
}


