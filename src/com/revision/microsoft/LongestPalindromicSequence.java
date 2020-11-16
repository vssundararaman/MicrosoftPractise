package com.revision.microsoft;

public class LongestPalindromicSequence {

    public static void main(String[] args) {
        String string = "malayalam";
        System.out.println (findLongestPalindromicSequence (string));
    }

    static String findLongestPalindromicSequence(String string) {
        if (string == null || string.length () == 0) {
            return "";
        }
        String output = "";

        for (int i = 0; i < string.length () - 1; i++) {
            String odd = findPalindromicSequence (string, i, i);

            if (odd.length () > output.length ()) {
                output = odd;
            }

            String even = findPalindromicSequence (string, i, i + 1);
            if (even.length () > output.length ()) {
                output = even;
            }
        }

        return output;
    }

    static String findPalindromicSequence(String s, int i, int j) {

        while (i >= 0 && j < s.length () && s.charAt (i) == s.charAt (j)) {
            i--;
            j++;
        }
        return s.substring (i + 1, j);
    }
}

