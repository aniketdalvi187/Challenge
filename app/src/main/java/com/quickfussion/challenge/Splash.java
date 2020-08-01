package com.quickfussion.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        SystemClock.sleep(3000);
        Intent mainintent = new Intent(Splash.this, MainActivity.class);
        startActivity(mainintent);
        finish();
    }
}