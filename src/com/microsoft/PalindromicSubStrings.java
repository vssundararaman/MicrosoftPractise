package com.microsoft;

public class PalindromicSubStrings {

    public static void main(String[] args) {
        String s = "abc";

        System.out.println (countSubStrings (s));
    }

    static int countSubStrings(String s){
        int count = 0;

        for(int i=0;i<s.length ();i++){
            count+= extractPalindromicSequence (s,i,i);
            count+= extractPalindromicSequence (s,i,i+1);
        }

        return count;
    }

    static int extractPalindromicSequence(String s, int left, int right){
        int count = 0;

        while(left>=0 && right< s.length () && (s.charAt (left) == s.charAt (right))){
            left --;
            right ++;
            count ++;
        }

        return count;
    }
}
