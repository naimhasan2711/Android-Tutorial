package com.example.user.eggtimerapp;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    boolean counterIsActive = false;
    public void updateTimer(int secondsLefts)
    {
        int minute = (int)(secondsLefts/60);
        int second = secondsLefts - (minute*60);

        String secondNumber = Integer.toString(second);
        String firstNumber = Integer.toString(minute);

        if(second <10){
            secondNumber = "0"+secondNumber;
        }
        if(minute<10){
            firstNumber = "0"+firstNumber;
        }

        timerTextView.setText(firstNumber + ":"+secondNumber);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SeekBar timerSeekBar = findViewById(R.id.timerSeekBar);
        timerTextView = findViewById(R.id.timerText);
        Button startButton = findViewById(R.id.startButton);


        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);
        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                updateTimer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if(counterIsActive == false) {

                    counterIsActive = true;
                    timerSeekBar.setEnabled(false);


                    new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                        @Override
                        public void onTick(long l) {

                            updateTimer((int) l / 1000);
                        }

                        @Override
                        public void onFinish() {
                            timerTextView.setText("00:00");
                            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                            mediaPlayer.start();
                        }
                    }.start();
                }

            }
        });


    }
}
