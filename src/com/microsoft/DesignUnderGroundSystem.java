package com.microsoft;

import java.util.HashMap;
import java.util.Map;

public class DesignUnderGroundSystem {

    private final String DELIMITER = ",";

    private Map<Integer, Event> arrivals;
    private Map<String, Average> averages;

    public static void main(String[] args) {

    }
    // TimeComplexity = O(1)
    //Space Complexity = 0(N+M)
    public DesignUnderGroundSystem() {
        arrivals = new HashMap<> ();
        averages = new HashMap<> ();
    }

    public void checkIn(int id, String stationName, int t) {
        arrivals.put (id, new Event (id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Event arrivalEvent = arrivals.get (id);
        arrivals.remove (id);

        int diff = t - arrivalEvent.time;
        String key = arrivalEvent.stationName.concat (DELIMITER).concat (stationName);

        Average average = averages.containsKey (key) ? averages.get (key) : new Average ();
        average.updateAverage (diff);

        averages.put (key,average);
    }

    public double getAverageTime(String startStation, String endStation){
        String key = startStation.concat (DELIMITER).concat (endStation);
        return averages.get (key).getAverage ();
    }
}

class Event {
    public int id;
    public String stationName;
    public int time;

    public Event(int id, String stationName, int time) {
        this.id = id;
        this.stationName = stationName;
        this.time = time;
    }
}

class Average {
    public double total = 0;
    public int count = 0;


    public void updateAverage(int diff) {
        ++count;
        total += diff;
    }

    public double getAverage() {
        return total / count;
    }
}
