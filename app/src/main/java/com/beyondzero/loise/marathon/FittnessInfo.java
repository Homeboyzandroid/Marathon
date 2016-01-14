package com.beyondzero.loise.marathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.beyondzero.loise.marathon.Adapter.CustomListAdapter;

public class FittnessInfo extends AppCompatActivity {

    ListView list;
    String[] itemname ={
            "The best type of exercise during pregnancy:",
            "Basic exercise guidelines:",
            "Physical changes that might affect your ability to exercise",
            "Best pregnancy exercises ",
            "Fitness for pregnant mothers"

    };

    Integer[] imgid={
            R.drawable.pregnant,
            R.drawable.swimming,
            R.drawable.posters,
            R.drawable.pregnant,
            R.drawable.swimming,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitnesss);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Fitnesss.class));

            }
        });
    }
}
