package com.microsoft;

public class AnalyzeUserVisitWebSiteDesignPattern {

    public static void main(String[] args) {

    }
//
//    static List<String> mostVisitedPattern(String[] userName, int[] timeStamp, String[] webSite) {
//
//        Map<String,List<Pair>> map = new HashMap<> ();
//        int n = userName.length;
//
//        //collect the website info for every user, key: userName, value(timeStamp, WebSite)
//        for(int i=0;i<n;i++){
//            map.putIfAbsent (userName[i], new ArrayList<> ());
//            map.get (userName[i]).add (new Pair (timeStamp[i],webSite[i]));
//        }
//
//        // count map to record every 3 combination occuring time for the different user.
//
//    }
}

class Pair {
    int time;
    String web;

    public Pair(int time, String web) {
        this.time = time;
        this.web = web;
    }
}
