package com.microsoft;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 * <p>
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * <p>
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance {

    public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";

        System.out.println (minDistance (word1,word2));
    }

    static int minDistance(String word1, String word2) {
        // dp[i][j] : minimum steps to convert i long word1 and j long word2
        int dp[][] = new int[word1.length () + 1][word2.length () + 1];

        for (int i = 0; i < word1.length (); i++) dp[i][0] = i;
        for (int j = 0; j < word2.length (); j++) dp[0][j] = j;

        for (int i = 1; i <= word1.length (); i++) {
            for (int j = 1; j <= word2.length (); j++) {
                if (word1.charAt (i - 1) == word2.charAt (j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                 else
                    // dp[i-1][j-1] : replace word1(i) with word2(j), because word1(0, i-1) == word2(0, j-1);
                    // dp[i  ][j-1] : delete word(j)
                    // dp[i-1][j  ] : delete word(i), because word1(0, i-1) == word2(0, j)
                    dp[i][j] = Math.min (dp[i - 1][j - 1], Math.min (dp[i][j - 1], dp[i - 1][j])) + 1;
            }
        }
        return dp[word1.length ()][word2.length ()];
    }
}
