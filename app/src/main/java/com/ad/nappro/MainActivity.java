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
    Button button15, button30, button45, button1, button2, button6, button8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textClock = (TextClock) findViewById(R.id.textClock);
        button15 = (Button) findViewById(R.id.button15Min);
        button30 = (Button) findViewById(R.id.button30Min);
        button45 = (Button) findViewById(R.id.button45Min);
        button1 = (Button) findViewById(R.id.button1Hr);
        button2 = (Button) findViewById(R.id.button2Hr);
        button6 = (Button) findViewById(R.id.button6Hr);
        button8 = (Button) findViewById(R.id.button8Hr);

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.MINUTE, 1);
                long target = calendar.getTimeInMillis();
                setAlarm(target);
                System.out.println(calendar);

            }
        });

        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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