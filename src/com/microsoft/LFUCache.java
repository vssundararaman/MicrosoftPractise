package com.microsoft;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int capacity;
    int min = -1;

    public static void main(String[] args) {

    }

    public LFUCache(int capacity){
        this.capacity = capacity;
        vals = new HashMap<> ();
        counts = new HashMap<> ();
        lists.put (1,new LinkedHashSet<> ());
    }

    public int get(int key){
        if(!vals.containsKey (key)){
            return -1;
        }

        int count = counts.get (key);
        counts.put (key,count+1);
        lists.get (count).remove (key);

        if(count == min && lists.get (count).size ()==0){
            min++;
        }

        if(!lists.containsKey (count+1)){
            lists.put (count+1,new LinkedHashSet<> ());
        }
            lists.get (count+1).add (key);
        return vals.get (key);
    }

    public void set(int key, int val){
        if(capacity <=0){
            return;
        }

        if(vals.containsKey (key)){
            vals.put (key,val);
            get (key);
            return;
        }

        if(vals.size ()>=capacity){
            int evit = lists.get (min).iterator ().next ();
            lists.get (min).remove (evit);
            vals.remove (evit);
        }

        vals.put (key,val);
        counts.put (key,1);
        min = 1;
        lists.get (1).add (key);
    }

}
