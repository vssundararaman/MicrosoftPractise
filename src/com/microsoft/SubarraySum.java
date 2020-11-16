package com.microsoft;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static void main(String[] args) {

        int[] nums = {1,1,1};

        System.out.println (subarraySum (nums,2));
    }

    static int subarraySum(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<> ();
        map.put (0,1);
        int sum = 0;
        int result = 0;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];

            if(map.containsKey (sum-k)){
                result += map.get (sum-k);
            }

            map.put (sum,map.getOrDefault (sum,0)+1);
        }



        return result;
    }
}
