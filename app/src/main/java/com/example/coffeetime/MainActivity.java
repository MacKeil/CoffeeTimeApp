package com.example.coffeetime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void FrenchPressAction(View view){
        //takes user's click and takes them to next activity
        Intent intent = new Intent(this, FrenchPressActivity.class);
        startActivity(intent);
    }

    public void DripMethodAction(View view){
        //takes user's click and takes them to the drip method activity
        Intent intent = new Intent(this, DripMethodActivity.class);
        startActivity(intent);
    }

    public void PercolatorMethodAction(View view){
        //takes user's click and takes them to the percolator method activity
        Intent intent = new Intent(this, PercolatorMethodActivity.class);
        startActivity(intent);
    }
}
