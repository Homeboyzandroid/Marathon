package com.example.loise.marathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.loise.marathon.Adapter.CustomAdapter;
import com.example.loise.marathon.Adapter.CustomGrid;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    GridView gridview;
    CustomAdapter lviewAdapter;
    ArrayList<HashMap<String, String>> oslist = new ArrayList<HashMap<String, String>>();

    private final static String web[] = {"About","Listen Live",
            "Statistics","Marathon Routes","Tips"};
    private final static int []imageId = {R.drawable.news,R.drawable.listen,
                                      R.drawable.graph,R.drawable.route,R.drawable.health};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                }

            }
        });
        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.menu_item);
      //  FloatingActionButton fab1=(FloatingActionButton)findViewById(R.id.menu_item2);

        fab.setOnClickListener( this);
        //fab1.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_item:
                startActivity(new Intent(getApplicationContext(),twitter.class));
               break;

           /* case R.id.menu_item2:
                startActivity(new Intent(getApplicationContext(),twitter.class));
               break;*/
        }

    }
}
