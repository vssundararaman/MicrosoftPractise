package com.microsoft;

public class MaximalRectangle {

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};

        System.out.println (findMaximalRectangle (matrix));
    }

    static int findMaximalRectangle(char[][] matrix){
        if(matrix == null || matrix.length ==0){
            return 0;
        }

        int col = matrix[0].length;
        int[] height = new int[col];
        int maxArea = 0, area;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == '0'){
                    height[j] = 0;
                }else{
                    height[j] += 1;
                }
            }

            for(int j=0; j<col;j++){
                if(height[j] == 0) continue;


                int left = 0, right =0;

                for(int k=j-1;k>=0;k--){
                    if(height[k]<height[j]) break;
                    left++;
                }

                for(int k=j+1;k<col;k++){
                    if(height[k]<height[j]) break;
                    right++;
                }

                area = height[j] * (1+left+right);
                if(area > maxArea) maxArea = area;
            }
        }

        return maxArea;
    }

    static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int col_nums = matrix[0].length;
        int height[] = new int[col_nums];
        int max_area = 0, area;
        for (int i=0; i< matrix.length;i++) {
            for(int j=0; j < col_nums; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }

            for(int j=0;j<col_nums;j++) {
                if (height[j]==0) continue;

                int left = 0, right = 0;

                // Check how many columns to my left have same or more height as me
                for(int k=j-1;k>=0;k--) {
                    if (height[k]<height[j]) break;
                    left++;
                }

                // Check how many columns to my right have same or more height as me
                for(int k=j+1;k<col_nums;k++) {
                    if (height[k]<height[j]) break;
                    right++;
                }

                area = height[j]*(1+left+right);
                if (area > max_area) max_area = area;
            }
        }

        return max_area;
    }
}
