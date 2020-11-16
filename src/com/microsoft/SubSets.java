package com.microsoft;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        System.out.println (subSets (nums));
    }

    static List<List<Integer>> subSets(int[] nums){

            List<List<Integer>> subSets = new ArrayList<> ();
            generateSubSets(0, nums,new ArrayList<Integer>(), subSets);
            return subSets;
    }

    private static void generateSubSets(int index, int[] nums, ArrayList<Integer> current, List<List<Integer>> subSets) {

        subSets.add (new ArrayList<> (current));

        for(int i=index;i<nums.length;i++){
            current.add (nums[i]);
            generateSubSets (i+1,nums,current,subSets);
            current.remove (current.size ()-1);
        }
    }
}
