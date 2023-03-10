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
        // starting alarm screen activity
        Intent alarmScreenIntent = new Intent(context, AlarmScreen.class);
        alarmScreenIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(alarmScreenIntent);
    }
}
