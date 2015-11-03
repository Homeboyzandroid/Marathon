package com.beyondzero.loise.marathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.beyondzero.loise.marathon.Adapter.CustomAdapter;
import com.beyondzero.loise.marathon.Adapter.CustomGrid;
import com.beyondzero.loise.marathon.Adapter.CustomListAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class News extends AppCompatActivity {

    ListView gridview;
    CustomAdapter lviewAdapter;
    ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();

    private final static int []imageId =
            {R.drawable.posters,
                    R.drawable.poster,
                    R.drawable.register,
            };

    private final static String web[] = {"About",
            "Register",
            "News",
           };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        //initalizing the adapter

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), web, imageId);

        /*gridview = (ListView)findViewById(R.id.listView);
        gridview.setAdapter(adapter);*/
    }
}
