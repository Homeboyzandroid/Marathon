package com.beyondzero.loise.marathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.beyondzero.loise.marathon.Nairobi;

public class Map extends AppCompatActivity {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Nairobi",
                "Mombasa",
                "Meru",
                "Uasin-Gishu",
                "Machakos",
                "Garisa",
                " Kisumu"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){

                    case 0:
                        startActivity(new Intent(getApplicationContext(),Nairobi.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(),Mombasa.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(),Meru.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(),Uasin.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(),Machakos.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(),Garissa.class));
                        break;
                    case 6:
                        startActivity(new Intent(getApplicationContext(),Kisumu.class));
                        break;
                }

            }

        });
    }

}