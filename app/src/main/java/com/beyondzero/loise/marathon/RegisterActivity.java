package com.beyondzero.loise.marathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Spinner spinner ,spinnercounty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.fl);

      //  spinner = (Spinner)findViewById(R.id.spinner);
        spinnercounty = (Spinner)findViewById(R.id.spinnercounty);

        // Create an ArrayAdapter using the string array and a default spinner layout

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.county, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnercounty.setAdapter(adapter1);


        Button buttonprev= (Button)findViewById(R.id.btn_prev);
        buttonprev.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Thank you for registering", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, JamboPay.class);
                startActivity(intent);
                finish();
            }
        });

        Button buttonnext= (Button)findViewById(R.id.btnnext);
        buttonnext.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Thank you for registering", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(RegisterActivity.this, Register2.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
