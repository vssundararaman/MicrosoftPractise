package com.microsoft;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 */
public class JumpGame2 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        System.out.println (jump (nums));
    }

    static int jump(int[] nums){

        int count = 0, currEnd = 0, currFarthest = 0;

        for(int i=0;i<nums.length-1;i++){
            currFarthest = Math.max (currFarthest, nums[i] + i);

            if(i == currEnd){
                count++;
                currEnd = currFarthest;
            }
        }

        return count;
    }
}
