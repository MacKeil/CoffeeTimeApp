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

    protected void startCoolTimer(View view){
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

    protected void startSteepTimer(View view){
        new CountDownTimer(360000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    protected void startPressTimer(View view){
        new CountDownTimer(30000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    //start the reset events
    protected void resetCoolTimer(View view){

    }

    protected void resetSteepTimer(View view){

    }

    protected void resetPressTimer(View view){

    }
}
