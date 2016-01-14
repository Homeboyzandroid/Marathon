package com.beyondzero.loise.marathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DonationInfo extends AppCompatActivity {
    TextView tv,tv2;
    Button btnok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_info);

        tv2 = (TextView)findViewById(R.id.txt3);
        tv2.setText(Html.fromHtml(getString(R.string.paybill)));


        tv = (TextView)findViewById(R.id.txt4);
       tv.setText(Html.fromHtml(getString(R.string.donate)));

        btnok = (Button)findViewById(R.id.btn_gotitdonate);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Donate.class));
            }
        });

    }
}
