package com.ad.nappro;

import android.os.Build;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;


public class Operations {

    // adds specifid min to current time
    // target is our actual alarm time
    // calls napPro function to add napPro mins to target time
    // returns an arraylist of epoch times (long)
    static ArrayList<Long> addMin(Integer min)
    {
        ArrayList<Long> alarmList = new ArrayList<>();
        LocalDateTime current, target;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            current = LocalDateTime.now();
            target = current.plusMinutes(min);
            alarmList = napPro(target);
        }
        return alarmList;
    }
    static void addHour(Integer hour)
    {
        LocalDateTime current, target;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            current = LocalDateTime.now();
            target = current.plusHours(hour);
        }
    }

    // add napPro mins to target time
    // convert yto epoch time epoch milli
    //returns an arraylist of epoch times (long)
    static ArrayList<Long> napPro(LocalDateTime lt)
    {
//        Integer[] napPro = {0, 2, 4, 5, 7, 10};
        Integer[] napPro = {0, 1, 2};
        ArrayList<Long> napProList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            for(int i = 0; i<2; i++)
            {
                LocalDateTime temp = lt.plusMinutes(napPro[i]);
                ZonedDateTime zdt = ZonedDateTime.of(temp, ZoneId.systemDefault());
                Long alarm = zdt.toInstant().toEpochMilli();
                napProList.add(alarm);
            }
        }
        // returning an empty list, related to api version if block
        return napProList;
    }
}
