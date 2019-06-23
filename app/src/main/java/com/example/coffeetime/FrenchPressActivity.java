package com.example.coffeetime;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FrenchPressActivity extends AppCompatActivity {
    protected TextView cool;
    protected TextView steep;
    protected TextView Press;
    protected Vibrator vibe;
    private long[] pattern1 = {500, 150, 400, 150, 300, 50, 100};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.french_press);
        cool = (TextView) findViewById(R.id.FPCoolTimer);
        steep = (TextView) findViewById(R.id.FPSteepTimer);
        Press = (TextView) findViewById(R.id.FPressTimer);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void startCoolTimer(View view){
        new CountDownTimer(25000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                cool.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    vibe.vibrate(VibrationEffect.createWaveform(pattern1, 0));
                }
                else{
                    vibe.vibrate(pattern1, 0);
                }
            }
        }.start();
    }

    public void startSteepTimer(View view){
        new CountDownTimer(360000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                //find the number of minutes left
                int minute = (int) millisUntilFinished / 60000;
                //find the number of seconds left, adjusted for the number of minutes left
                int second = (int) (millisUntilFinished - (minute * 60000));
                //format the string before passing it to the view
                String out = minute  + ":" + second;
                steep.setText(out);
            }

            @Override
            public void onFinish() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    vibe.vibrate(VibrationEffect.createWaveform(pattern1, 0));
                }
                else{
                    vibe.vibrate(pattern1, 0);
                }
            }
        }.start();
    }

    public void startPressTimer(View view){
        new CountDownTimer(30000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                Press.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    vibe.vibrate(VibrationEffect.createWaveform(pattern1, 0));
                }
                else{
                    vibe.vibrate(pattern1, 0);
                }
            }
        }.start();
    }

    //start the reset events
    public void resetCoolTimer(View view){
        vibe.cancel();//stop any vibration
        cool.setText(Integer.toString(25));// reset the clock
    }

    public void resetSteepTimer(View view){
        vibe.cancel();//stop any vibration
        steep.setText("6:00");//reset the clock
    }

    public void resetPressTimer(View view){
        vibe.cancel(); //stop any vibration
        Press.setText("30");
    }
}
