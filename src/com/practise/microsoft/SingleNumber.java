package com.practise.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * 136. Single Number
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2,2,1};

        System.out.println (singleNumber (nums));
    }

    static int singleNumber(int[] nums){

        List<Integer> numberList = new ArrayList<> ();

        for(int i: nums){
            if(!numberList.contains (i)){
                numberList.add (i);
            }else{
                numberList.remove (new Integer (i));
            }
        }
        return numberList.get (0);
    }

}
