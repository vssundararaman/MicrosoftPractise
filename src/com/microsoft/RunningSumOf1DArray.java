package com.microsoft;

import java.util.Arrays;

public class RunningSumOf1DArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println (Arrays.toString (runningSum (nums)));
    }

    static int[] runningSum(int[] nums){
        int[] result = new int[nums.length];
        int sum = 0;

        for(int i=0;i< nums.length;i++){
            result[i] = sum + nums[i];
            sum = result[i];
        }

        return  result;
    }
}
