package com.beyondzero.loise.marathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.timessquare.CalendarPickerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.flhmnewlogo);

        /*Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);*/

        CalendarPickerView calendar = (CalendarPickerView) findViewById(R.id.calendar_view);

        Calendar nextyear = Calendar.getInstance();
        //nextyear.add(Calendar.YEAR, 1);
        nextyear.set(2016, Calendar.AUGUST, 15);

        Date today = new Date();
        GregorianCalendar nextyr = new GregorianCalendar(2016, Calendar.AUGUST, 15);
        calendar.init(today, nextyr.getTime())
                // calendar.init(today, nextyear.getTime())
                .withSelectedDate(today)
        .inMode(CalendarPickerView.SelectionMode.RANGE);
        calendar.highlightDates(getActivities());
        calendar.highlightDates(getRun());

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        GoogleApiClient client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private ArrayList<Date> getRun() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");

        String datelast = "6-03-2016";
        Date date = null;
        try {
            date = sdf.parse(datelast);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList<Date> holidays = new ArrayList<>();
        holidays.add(date);
        return holidays;

    }

    private ArrayList<Date> getActivities() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "26-01-2016";
        Date date = null;
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList<Date> holidays = new ArrayList<>();
        holidays.add(date);
        return holidays;

    }
}