package com.ad.nappro;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class BroadCastManager extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
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
        MediaPlayer mp = MediaPlayer.create(context, alert);
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
        Toast.makeText(context, "Alarm has triggered", Toast.LENGTH_SHORT).show();
    }
}
