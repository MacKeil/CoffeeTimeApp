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


public class DripMethodActivity extends AppCompatActivity {
    protected TextView DripTimer;
    protected Vibrator vibe;
    protected long[] pattern = {500,140,500,100,350};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drip_method);
        DripTimer = (TextView) findViewById(R.id.dripTimer);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void onResetPress(View view){
        vibe.cancel();
        DripTimer.setText(Integer.toString(25));
    }

    public void onStartPress(View view){
        new CountDownTimer(25000, 1000){
            @Override
            public void onTick(long l) {
                DripTimer.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    vibe.vibrate(VibrationEffect.createWaveform(pattern, 0));
                }
                else{
                    vibe.vibrate(pattern, 0);
                }
            }
        }.start();
    }
}
