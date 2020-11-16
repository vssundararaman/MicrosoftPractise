package com.practise.microsoft;

import java.util.HashMap;
import java.util.Map;

public class DesignUnderGroundSystem {

    private final String DELIMITER = ",";

    private Map<Integer, Event> arrivals;
    private Map<String, Average> averages;

    public DesignUnderGroundSystem(){
        arrivals = new HashMap<> ();
        averages = new HashMap<> ();
    }

    public void checkIn(int id, String stationName, int time){
        arrivals.put (id, new Event (id,stationName,time));
    }

    public void checkOut(int id, String stationName, int time){
        Event arrivalEvent = arrivals.get (id);
        arrivals.remove (id);

        int diff = time - arrivalEvent.time;
        String key = arrivalEvent.stationName.concat (DELIMITER).concat (stationName);

        Average average = averages.containsKey (key)?averages.get (key): new Average ();

        average.updateTotal (diff);
    }

    public double getAverageTime(String startStation, String endStation){
        String key = startStation.concat (DELIMITER).concat (endStation);
        return averages.get (key).getAverage ();
    }
}

class Event{
    public int id;
    public String stationName;
    public int time;

    public Event (int id, String stationName, int time){
        this.id = id;
        this.stationName = stationName;
        this.time = time;
    }
}

class Average{
    public double total = 0;
    public int count = 0;

    public void updateTotal(int diff){
        ++count;
        total += diff;
    }

    public double getAverage(){
        return total/count;
    }
}
