package com.microsoft;

public class LargestHistogramInDiagram {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};

        System.out.println (largestRectangleArea (heights));
    }

    static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int result = 0;


        left[0] = 0;

        //Build left
        for (int i = 1; i < n; i++) {
            int currentLeft = i - 1;
            while (currentLeft >= 0 && heights[currentLeft] >= heights[i]) {
                currentLeft = left[currentLeft] - 1;
            }

            left[i] = currentLeft + 1;
        }

        //Build right
        right[n-1] = n-1;
        for(int j=n-2; j>=0;j--){
            int currentRight = j+1;
            while (currentRight < n && heights[j] <= heights[currentRight]){
                currentRight = right[currentRight] + 1;
            }

            right[j] = currentRight - 1;
        }

        //Compare heights
        for(int i=0;i<n;i++){
            result = Math.max(result, (right[i]-left[i]+1)*heights[i]);
        }

        //Return result
        return result;
    }
}

