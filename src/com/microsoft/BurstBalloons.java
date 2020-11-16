package com.microsoft;

public class BurstBalloons {

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        System.out.println (maxCoins (nums));
        System.out.println (maxCoins1 (nums));
    }

    static int maxCoins(int[] nums) {
        int[] numcoins = new int[nums.length + 2];
        int n = 1;

        for (int x : nums) {
            if (x > 0) {
                numcoins[n++] = x;
            }
        }
        numcoins[0]=numcoins[n++]=1;

        int[][] dp = new int[n][n];

        for (int k = 2; k < n; ++k) {
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i) {
                    dp[left][right] = Math.max (dp[left][right], numcoins[left] * numcoins[i] * numcoins[right]
                            + dp[left][i] + dp[i][right]);
                }
            }

        }
        return dp[0][n - 1];
    }

    static int maxCoins1(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max (dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}
