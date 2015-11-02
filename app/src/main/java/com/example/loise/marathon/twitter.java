package com.example.loise.marathon;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ListView;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;
import com.twitter.sdk.android.tweetui.UserTimeline;

public class twitter extends ListActivity {
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);


        listview = (ListView) findViewById(R.id.list);
        final UserTimeline userTimeline = new UserTimeline.Builder().screenName("KBCChannel1").build();

        TweetTimelineListAdapter adapter;
        adapter = new TweetTimelineListAdapter(this, userTimeline);
        adapter = new TweetTimelineListAdapter.Builder(this).setTimeline(userTimeline).build();

        listview.setAdapter(adapter);


    }
}
