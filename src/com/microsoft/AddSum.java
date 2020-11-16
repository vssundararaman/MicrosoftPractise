package com.microsoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AddSum {

    public static void main(String[] args) {

        int[] nums = {2,7,11,15};

        int target = 9;

        System.out.println (Arrays.toString (AddSum (nums,target)));
    }

    static int[] AddSum(int[] nums, int target){

        Map<Integer, Integer> numMap = new HashMap<> ();

        for(int i=0;i<nums.length;i++){

            int compliment = target - nums[i];

            if(numMap.containsKey (compliment)){
                return new int[]{numMap.get (compliment),i};
            }

            numMap.put (nums[i],i);
        }

        throw new IllegalArgumentException("No Solution Found");
    }
}
