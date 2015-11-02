package com.example.loise.marathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.loise.marathon.Adapter.CustomAdapter;
import com.example.loise.marathon.Adapter.CustomGrid;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    GridView gridview;
    CustomAdapter lviewAdapter;
    ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();

    private final static String web[] = {"About",
            "Social",
            "Listen Live",
            "Statistics",
            "Marathon Routes",
            "Tips"};
    private final static int []imageId = {R.drawable.news,
            R.drawable.social,
            R.drawable.listen,
            R.drawable.graph,
            R.drawable.route,
            R.drawable.health};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

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
                        startActivity(new Intent(getApplicationContext(), Social.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), Listen.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), Social.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), Map.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(), Social.class));
                        break;
                }

            }
        });
    }
}
