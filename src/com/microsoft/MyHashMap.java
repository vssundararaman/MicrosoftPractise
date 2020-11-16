package com.microsoft;

import java.util.Arrays;

public class MyHashMap {
    int a[];

    public MyHashMap(){
        a = new int[1000001];
        Arrays.fill (a,-1);
    }

    public void put(int key, int val){
        a[key] = val;
    }

    public int get(int key){
        return a[key];
    }

    public void remove(int key){
        a[key] = -1;
    }
}
