package com.beyondzero.loise.marathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.fl);
    }
}
