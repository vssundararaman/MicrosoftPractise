package com.microsoft;

public class RectangleOverLap {

    public static void main(String[] args) {

        int[] rec1 = {0,0,2,2}, rec2 = {1,1,3,3};

        System.out.println (isRectangleOverlap (rec1,rec2));

    }

    static boolean isRectangleOverlap(int[] rect1, int[] rect2){
        //          0  <  3             0     < 3             0     < 3             1 <  2
        return rect1[0] < rect2[2] && rect1[1]<rect2[3] && rect1[0] < rect2[2] && rect2[1]<rect1[3];
    }
}
