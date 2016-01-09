package com.beyondzero.loise.marathon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.beyondzero.loise.marathon.Adapter.CustomAdapter;
import com.beyondzero.loise.marathon.Adapter.CustomGrid;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

import cn.iwgang.countdownview.CountdownView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    GridView gridview;
    CustomAdapter lviewAdapter;
    ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();

    private final static String web[] =
            {"About",
             "Register",
            "News",
            "Calender",
            "Statistics",
            "Fitness",
            "  Media",
            "Route Map",
            "Donation",
            "Merchandise",
            "FAQ s",
            "Twitter",
            "Facebook",
            "Instagram"
            };
    private final static int []imageId =
            {R.drawable.abouticon,
            R.drawable.reg,
            R.drawable.news,
            R.drawable.calendaricon,
            R.drawable.img3,
            R.drawable.fitnessicon,
            R.drawable.videomedia,
            R.drawable.routemap,
            R.drawable.donate,
            R.drawable.paymentcart,
            R.drawable.faq,

            R.drawable.twitter,
            R.drawable.facebook,
            R.drawable.instagram};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.fl);

        //initalizing the adapter
            CustomGrid adapter = new CustomGrid(getApplicationContext(), web, imageId);

        gridview = (GridView)findViewById(R.id.gridView);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getActivity(),"welcome to"+web,Toast.LENGTH_SHORT).show();ra

                switch (position) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), HAsh.class));
                        break;
                    case 1:

                        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));

                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), News.class));
                        break;

                    case 3:
                        startActivity(new Intent(getApplicationContext(), Calender.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), Statistics.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(getApplicationContext(), Listen.class));
                        break;
                    case 7:
                        startActivity(new Intent(getApplicationContext(), Map.class));
                        break;
                    case 8:
                        startActivity(new Intent(getApplicationContext(),Donate.class));
                        break;
                    case 9:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(getApplicationContext(), twitter.class));
                        break;
                    case 12:
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.facebook.com/beyondzerocampaign/"));
                        startActivity(intent);
                        break;
                    case 13:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        break;


                }

            }
        });

        String oldTime = "06.03.2016, 9:00";
        //this is the footer section with the countdown timer
        CountdownView mCvCountdownViewTest2 = (CountdownView)findViewById(R.id.cv_countdownViewTest2);
        mCvCountdownViewTest2.setTag("test2");

        long time2 = (long)57 * 24 * 60 * 60 * 1000;
        mCvCountdownViewTest2.start(time2);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            /*case R.id.menu_item:
                startActivity(new Intent(getApplicationContext(),twitter.class));
               break;*/

           /* case R.id.menu_item2:
                startActivity(new Intent(getApplicationContext(),twitter.class));
               break;*/
        }

    }
}
