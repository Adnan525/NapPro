package com.ad.nappro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextClock textClock;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textClock = (TextClock) findViewById(R.id.textClock);
        button = (Button) findViewById(R.id.buttonAdd);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.MINUTE, 1);
                long target = calendar.getTimeInMillis();
                setAlarm(target);
                System.out.println(Calendar.getInstance().getTimeInMillis());
                System.out.println(target);
            }
        });
    }


    private void setAlarm(long time) {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent i = new Intent(this, BroadCastManager.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
        manager.set(AlarmManager.RTC_WAKEUP, time, pi);

        Toast.makeText(this, "Alarm is set", Toast.LENGTH_SHORT).show();
    }
}