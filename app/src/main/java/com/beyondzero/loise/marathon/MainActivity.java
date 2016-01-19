package com.beyondzero.loise.marathon;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beyondzero.loise.marathon.Adapter.CustomAdapter;
import com.beyondzero.loise.marathon.Adapter.CustomGrid;
import com.google.android.gms.fitness.Fitness;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import cn.iwgang.countdownview.CountdownView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    GridView gridview;
    CustomAdapter lviewAdapter;
    ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();
    private TextView tvDay, tvHour, tvMinute, tvSecond, tvEvent;
    private LinearLayout linearLayout1, linearLayout2;
    private Handler handler;
    private Runnable runnable;

    private final static String web[] =
            {"About",
             "Register",
            "News",
            "Calender",
            "Statistics",
            "Fitness",
            " Media",
            "Route Map",
            "Donation",
           // "Merchandise",
            "FAQs",
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
           // R.drawable.paymentcart,
            R.drawable.faq,
            R.drawable.twitter,
            R.drawable.facebook,
            R.drawable.instagram};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.flhmnewlogo);

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
                        startActivity(new Intent(getApplicationContext(), About.class));
                        break;
                    case 1:

                        startActivity(new Intent(getApplicationContext(), RegistrationInfo.class));

                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(),MainActivityRss.class));
                        break;

                    case 3:
                        startActivity(new Intent(getApplicationContext(), Calender.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), Statistics.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(),Fitnesss.class));
                        break;
                    case 6:
                        startActivity(new Intent(getApplicationContext(), Listen.class));
                        break;
                    case 7:
                        startActivity(new Intent(getApplicationContext(), RoutesActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(getApplicationContext(),DonationInfo.class));
                        break;
                   /* case 9:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        break;*/
                    case 9:
                        startActivity(new Intent(getApplicationContext(), FAQsActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(getApplicationContext(), twitter.class));
                        break;
                    case 11:
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.facebook.com/beyondzerocampaign/"));
                        startActivity(intent);
                        break;
                    case 12:

                        Uri uri = Uri.parse("http://instagram.com/_u/beyondzerokenya");
                        Intent Instagram = new Intent(Intent.ACTION_VIEW, uri);

                        Instagram.setPackage("com.instagram.android");

                        try {
                            startActivity(Instagram);
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("https://www.instagram.com/beyondzerokenya")));
                        }
                        /*startActivity(new Intent(getApplicationContext(),Instagram.class));
                        break;*/


                }

            }
        });


        initUI();
        countDownStart();
    }
    @SuppressLint("SimpleDateFormat")
    private void initUI() {
        linearLayout1 = (LinearLayout) findViewById(R.id.ll1);
        linearLayout2 = (LinearLayout) findViewById(R.id.ll2);
        tvDay = (TextView) findViewById(R.id.txtTimerDay);
        tvHour = (TextView) findViewById(R.id.txtTimerHour);
        tvMinute = (TextView) findViewById(R.id.txtTimerMinute);
        tvSecond = (TextView) findViewById(R.id.txtTimerSecond);
        tvEvent = (TextView) findViewById(R.id.tvevent);
    }
    // //////////////COUNT DOWN START/////////////////////////
    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
                    // Here Set your Event Date
                    Date futureDate = dateFormat.parse("2016-03-6");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        tvDay.setText("" + String.format("%02d", days));
                        tvHour.setText("" + String.format("%02d", hours));
                        tvMinute.setText("" + String.format("%02d", minutes));
                        tvSecond.setText("" + String.format("%02d", seconds));
                    } else {
                        linearLayout1.setVisibility(View.VISIBLE);
                        linearLayout2.setVisibility(View.GONE);
                        tvEvent.setText("Android Event Start");
                        handler.removeCallbacks(runnable);
                        // handler.removeMessages(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 0);
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
