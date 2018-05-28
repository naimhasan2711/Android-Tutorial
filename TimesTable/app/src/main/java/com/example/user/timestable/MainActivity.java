package com.example.user.timestable;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long milisecondsUntilDone) {

                Log.i("Until finished-> ", String.valueOf(milisecondsUntilDone/1000));

            }

            @Override
            public void onFinish() {

                Log.i("Done,","Countdown finished");
            }
        }.start();



        /*
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {

                Log.e("Runable has run->" , "A second must be delayed");
                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);

        */
    }
}
