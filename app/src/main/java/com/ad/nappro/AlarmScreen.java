package com.ad.nappro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlarmScreen extends AppCompatActivity {
    Button stopButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_screen);

        stopButton = (Button) findViewById(R.id.stopButton);
        // uniform resource identifier
        // used to locate abstract or physical resource
        Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if(alert == null){
            // alert is null, using backup
            alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            // I can't see this ever being null (as always have a default notification)
            // but just incase
            if(alert == null) {
                // alert backup is null, using 2nd backup
                alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            }
        }
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), alert);
        mp.setLooping(true);
        mp.start();
//        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "nappro")
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("Nap Pro")
//                .setContentText("Nap pro test notification")
//                .setAutoCancel(true)
//                .setSound(alarmSound);
//
//        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
//        notificationManagerCompat.notify(111, builder.build());
        Toast.makeText(getApplicationContext(), "Alarm has triggered", Toast.LENGTH_SHORT).show();
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                finish();

            }
        });
    }
}