package com.microsoft;

public class FirstMissingPositive {

    public static void main(String[] args) {

        int[] nums1 = {1,2,0};
        System.out.println (findFirstMissingPositive (nums1));
    }

    static int findFirstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int n = nums.length;
        boolean containsOne = false;

        //step 1: Negative Numbers and Numbers to Greater than n to change to 1
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                containsOne = true;
            } else if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        if (containsOne == false) return 1;

        //Step 2: Make the index to negative ones.
        for (int i = 0; i < n; i++) {
            int index = Math.abs (nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -1 * nums[index];
            }
        }

        //step3 - Find the First Positive Number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
