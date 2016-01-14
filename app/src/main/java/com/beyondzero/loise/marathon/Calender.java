package com.beyondzero.loise.marathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.fl);

        /*Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);*/

        CalendarPickerView calendar = (CalendarPickerView) findViewById(R.id.calendar_view);

        Calendar nextyear = Calendar.getInstance();
        //nextyear.add(Calendar.YEAR, 1);
        nextyear.set(2016, Calendar.AUGUST, 15);

        Date today=new Date();
        GregorianCalendar nextyr = new GregorianCalendar(2016, Calendar.AUGUST, 15);
        calendar.init(today, nextyr.getTime())
       // calendar.init(today, nextyear.getTime())
                .withSelectedDate(today);

    }
}
