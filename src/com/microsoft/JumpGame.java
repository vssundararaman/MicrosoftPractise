package com.microsoft;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        System.out.println (canJump (nums));
    }

    static boolean canJump(int[] nums) {
        int lastIndexPosition = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastIndexPosition) {
                lastIndexPosition = i;
            }
        }

        return lastIndexPosition == 0;
    }
}
