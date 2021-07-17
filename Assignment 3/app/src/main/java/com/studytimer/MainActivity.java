package com.studytimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private boolean started = false;
    private TextView time;
    private Chronometer timer;
    private ImageButton start, pause, stop;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        time = findViewById(R.id.time);
        timer = findViewById(R.id.timer);
        start = findViewById(R.id.start);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);

        preferences = getSharedPreferences("time", Context.MODE_PRIVATE);
        time.setText(preferences.getString("time", "00:00"));

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!started){
                    timer.setBase(SystemClock.elapsedRealtime());
                    started = true;
                }
                timer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.stop();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.stop();
                started = false;
                String thisTime = preferences.getString("time", "00:00");
                if (!thisTime.equals("00:00")) {
                    int min = Integer.parseInt(thisTime.split(":")[0]);
                    int sec = Integer.parseInt(thisTime.split(":")[1]);

                    String nowTime = timer.getText().toString();
                    min += Integer.parseInt(nowTime.split(":")[0]);
                    sec += Integer.parseInt(nowTime.split(":")[1]);

                    thisTime = min + ":" + sec;
                }else {
                    thisTime = timer.getText().toString();
                }

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("time", thisTime);
                editor.apply();

                time.setText(thisTime);
                timer.setBase(SystemClock.elapsedRealtime());
            }
        });
    }
}
