package com.microsoft;

public class MaximumRectangle {

    public static void main(String[] args) {

        char [][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        System.out.println (maximalRectangle (matrix));
    }

    static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
                int min = height[j];
                for (int k = j; k >= 0 && min > 0; k--) {
                    min = Math.min(min, height[k]);
                    max = Math.max(max, min * (j - k + 1));
                }
            }
        }
        return max;
    }
}
