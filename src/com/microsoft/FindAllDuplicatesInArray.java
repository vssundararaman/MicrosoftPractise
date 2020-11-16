package com.microsoft;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

    public static void main(String[] args) {

        int[] number = {4,3,2,7,8,2,3,1};

        System.out.println (findAllDuplicates (number));
        System.out.println (findDuplicates (number));
    }

    static List<Integer> findAllDuplicates(int[] numbers){
        List<Integer> result = new ArrayList<> ();

        for(int i=0;i<numbers.length;i++){
            int index = Math.abs (numbers[i]) - 1;

            if(numbers[index]<0) result.add (index +1);
            numbers[index] = -numbers[index];
        }
        return result;
    }

    static List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list =new ArrayList<Integer>();
        int[] arr=new int[nums.length+1];

        for(int i=0;i<nums.length;i++)
        {
            arr[nums[i]]++;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(arr[nums[i]]==2)
            {
                list.add(nums[i]);
                arr[nums[i]]=-1;

            }
        }
        return list;
    }


}
