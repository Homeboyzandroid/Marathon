package com.beyondzero.loise.marathon;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Instagram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        /*Uri uri = Uri.parse("https://www.instagram.com/beyondzerokenya/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);*/

        Uri uri = Uri.parse("http://instagram.com/_u/beyondzerokenya");
        Intent Instagram = new Intent(Intent.ACTION_VIEW, uri);

        Instagram.setPackage("com.instagram.android");

        try {
            startActivity(Instagram);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/beyondzerokenya")));
        }
    }

}
