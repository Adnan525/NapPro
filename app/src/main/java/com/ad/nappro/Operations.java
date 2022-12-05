package com.ad.nappro;

import android.os.Build;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;


public class Operations {
    static ArrayList<Long> addMin(Integer min)
    {
        ArrayList<Long> alarmList = new ArrayList<>();
        LocalDateTime current, target;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            current = LocalDateTime.now();
            target = current.plusMinutes(1);
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

    static ArrayList<Long> napPro(LocalDateTime lt)
    {
//        Integer[] napPro = {-5, 0, 2, 4, 5, 7, 10};
        // test
        Integer[] napPro = {0, 1};
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
