package com.example.loise.marathon.Adapter;

import android.app.Application;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

/**
 * Created by faith on 10/30/15.
 */
public class TwitterApplication extends Application {
    private static final String TWITTER_KEY = "CtXW8KLLGFfQTqWlrdoK7oUbR";
    private static final String TWITTER_SECRET = "xq0mHEOlOpBVfr1uyvehFF1dt05YIAPxCHav0diBfr99QuBXrL";

    @Override
    public void onCreate() {
        super.onCreate();
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
      //  TwitterAuthConfig authConfig= new TwitterAuthConfig(CtXW8KLLGFfQTqWlrdoK7oUbR,xq0mHEOlOpBVfr1uyvehFF1dt05YIAPxCHav0diBfr99QuBXrL);
    }
}
