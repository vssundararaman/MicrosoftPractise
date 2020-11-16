package com.microsoft;

public class DecodeWays {

    public static void main(String[] args) {
        String  string= "226";

        System.out.println (numDecoding (string));

    }

    static int numDecoding(String string) {
        int dp[] = new int[string.length () + 1];
        dp[0] = 1;
        dp[1] = string.charAt (0) == '0' ? 0 : 1;

        for (int i = 2; i <= string.length (); i++) {

            int oneDigit = Integer.valueOf (string.substring (i - 1, i));

            int twoDigit = Integer.valueOf (string.substring (i - 2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            if(twoDigit >=10 && twoDigit <=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[string.length ()];
    }
}

