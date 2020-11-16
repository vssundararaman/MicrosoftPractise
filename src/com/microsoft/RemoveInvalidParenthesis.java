package com.microsoft;

import java.util.*;

public class RemoveInvalidParenthesis {

    public static void main(String[] args) {
//        String s = "()())()";
//
//        System.out.println (removeInvalidParenthesis (s));
//
//        s = "(a)())()";
//        System.out.println (removeInvalidParenthesis (s));

        String s = "";
        System.out.println (removeInvalidParenthesis (s));
    }

    static List<String> removeInvalidParenthesis(String s){
        List<String> res = new ArrayList<> ();

        if(s == null) return res;

        Set<String> visited = new HashSet<> ();
        Queue<String> queue = new LinkedList<> ();

        queue.add (s);
        visited.add (s);

        boolean found = false;

        while(!queue.isEmpty ()){
            s = queue.poll ();

            if(isValid(s)){

                if(s.length() ==0){
                    s = "\"" + s + "\"";
                }
                res.add (s);
                found = true;
            }

            if(found) continue;

            for(int i=0;i<s.length ();i++){
                if(s.charAt (i) != '(' && s.charAt(i) !=')') continue;

                String t = s.substring (0,i) + s.substring (i+1);

                if(!visited.contains (t)){
                    queue.add (t);
                    visited.add (t);
                }
            }
        }

        return res;
    }

    private static boolean isValid(String s) {

        int count = 0;

        for(int i=0;i<s.length ();i++){
            char c = s.charAt (i);

            if(c == '(') count++;
            if(c == ')' && count--==0) return false;
        }
        return count == 0;
    }
}
