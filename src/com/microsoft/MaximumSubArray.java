package com.microsoft;

public class MaximumSubArray {

    public static void main(String[] args) {

        int[] nums = {2,3,-2,4};

        System.out.println (findMaximumSumArray (nums));
    }

    static int findMaximumSumArray(int[] nums){
        if(nums.length ==0){
            return -1;
        }

        int current_max = nums[0];
        int current_min = nums[0];
        int final_result = nums[0];

        for(int i=1; i<nums.length;i++){

            int temp = current_max;
            current_max = Math.max (Math.max (current_max * nums[i],current_min * nums[i]), nums[i]);

            current_min = Math.min(Math.min (temp * nums[i],current_min * nums[i]),nums[i]);

            if(current_max > final_result){
                final_result = current_max;
            }
        }

        return final_result;
    }
}
