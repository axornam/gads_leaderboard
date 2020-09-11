package com.axornam.gads_leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.SplashTheme);
        Intent intent = new Intent(getApplicationContext(), LeadersActivity.class);
        startActivity(intent);
        finish();
    }
}