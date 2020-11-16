package com.microsoft;

import java.util.*;

public class RandomizedSet {

    List<Integer> list = new ArrayList<> ();
    Map<Integer,Integer> map = new HashMap<> ();
    Random random = new Random ();

    public static void main(String[] args) {

    }

    public boolean insert(int val){
        if(map.containsKey (val)) return false;
        map.put (val,map.size ());
        list.add (val);
        return true;
    }

    public boolean remove(int val){
        if(!map.containsKey (val)) return false;
        list.set (map.get (val),list.get (list.size () -1));
        map.put (list.remove (list.size ()-1),map.get(val) );
        map.remove (val);
        return true;
    }

    public int getRandom(){
        return list.get (random.nextInt (list.size ()));
    }
}
