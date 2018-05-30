package com.naimsplanet.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = findViewById(R.id.buttonRoll);
        final ImageView leftImage = findViewById(R.id.leftDice);
        final ImageView rightImage = findViewById(R.id.rightDice);
        final int[] diceImage = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6};

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Log.e("Message","Button Tapped");
                Random randomNumberGenerator = new Random();
                int randomNumber = randomNumberGenerator.nextInt(6);
                Log.d("dice","Random Number->"+randomNumber);
                leftImage.setImageResource(diceImage[randomNumber]);

                randomNumber = randomNumberGenerator.nextInt(6);

                rightImage.setImageResource(diceImage[randomNumber]);

            }
        });


    }
}
