package com.practise.microsoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {2,7,11,15};

        System.out.println (Arrays.toString (twoSum (nums,9)));
    }

    static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<> ();

        for(int i=0;i<nums.length-1; i++){

            int compliment = target - nums[i];

            if(numMap.containsKey (compliment)){
                return new int[]{numMap.get (compliment), i};
            }

            numMap.put (nums[i],i);
        }

        throw new IllegalArgumentException("No Soution Found");
    }
}
