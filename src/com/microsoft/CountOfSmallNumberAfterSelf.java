package com.microsoft;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallNumberAfterSelf {

    public static void main(String[] args) {

        int[] nums = {5,2,6,1};
        System.out.println (countSmaller (nums));
    }

    static List<Integer> countSmaller(int[] nums){
        List<Integer> result = new ArrayList<> ();

        if(nums.length == 0){
            return  result;
        }

        if(nums.length > 1){

            for(int i = 0; i<nums.length-1;i++){

                int count = 0;

                for(int j=i+1;j<nums.length;j++){
                    if(nums[j] < nums[i]){
                        count ++;
                    }
                }
                result.add (count);
            }
        }

        result.add (0);
        return result;
    }
}
