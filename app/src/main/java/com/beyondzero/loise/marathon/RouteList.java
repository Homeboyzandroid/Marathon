package com.beyondzero.loise.marathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RouteList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_list);

       /* getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.flhmnewlogo);*/

        String[] myDataset = {"21 Kms Route", "10 Kms Route", "5 kms Route", "2 Kms Route",};

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myDataset);

        ListView myList = (ListView) findViewById(R.id.listView1);
        myList.setAdapter(myAdapter);

       myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(),Maptwentyone.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), Tenkms.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), Fivekms.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), Twokms.class));
                        break;
                }
            }
        });
    }
}
