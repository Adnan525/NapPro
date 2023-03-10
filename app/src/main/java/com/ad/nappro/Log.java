package com.ad.nappro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Log extends AppCompatActivity {

    TextView textView;
    Button quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        textView = (TextView) findViewById(R.id.alarmLog);
        quitButton = (Button) findViewById(R.id.quitButton);

        // quit button to close the log activity
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}