package com.example.coffeetime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-9055788167131082~1106245768");

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9055788167131082~1106245768");
        interstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void FrenchPressAction(View view){
        //takes user's click and takes them to next activity
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        Intent intent = new Intent(this, FrenchPressActivity.class);
        startActivity(intent);
    }

    public void DripMethodAction(View view){
        //takes user's click and takes them to the drip method activity
        AdLoader(view);//init the interstitial ad
        Intent intent = new Intent(this, DripMethodActivity.class);
        startActivity(intent);
    }

    public void PercolatorMethodAction(View view){
        //takes user's click and takes them to the percolator method activity
        AdLoader(view);//init the interstitial ad
        Intent intent = new Intent(this, PercolatorMethodActivity.class);
        startActivity(intent);
    }

    private void AdLoader(View view){
        //function sets up the ad and shows  it
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        else{
            Log.d("TAG", "The interstitial wasn't loaded yet");
        }
    }
}
