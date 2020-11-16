package com.microsoft;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String str = "aab";

        System.out.println (partition (str));
    }

    static List<List<String>> partition(String s) {
        if (s == null || s.length () == 0) {
            return new ArrayList<> ();
        }

        List<List<String>> result = new ArrayList<> ();
        helper(s, new ArrayList<> (), result);
        return result;
    }

    private static void helper(String s, List<String> step, List<List<String>> result) {

        //Base case
        if(s ==null || s.length ()==0){
            result.add (new ArrayList<> (step));
            return;
        }

        for(int i=1;i <= s.length ();i++){
            String temp = s.substring (0,i);

            if(!isPalindrome(temp)) continue;

            step.add (temp);
            helper (s.substring (i,s.length ()),step,result); //Explore
            step.remove (step.size () - 1); //Unchoose
        }
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right    = s.length ()-1;
        while (left <= right){
            if(s.charAt (left) !=s.charAt (right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
