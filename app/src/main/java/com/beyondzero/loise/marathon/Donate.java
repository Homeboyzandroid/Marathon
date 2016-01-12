package com.beyondzero.loise.marathon;


import android.app.ProgressDialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.beyondzero.loise.marathon.Adapter.VolleyApplication;


import java.util.HashMap;

import java.util.Map;


/**
 * A login screen that offers login via email/password.
 */
public class Donate extends AppCompatActivity implements OnClickListener {
    EditText etfirstname, etlastname, etemail, etphone, etmpesaid, etamount;
    String url = "http://www.flhm.or.ke/api/v2/donation";

    String firstname, lastname, email, phone, mpesaid, amount;

    ProgressDialog PD;

    //Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        //adding the logo on toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.fl);

        PD = new ProgressDialog(this);
        PD.setMessage("Loading.....");
        PD.setCancelable(false);

        etfirstname = (EditText) findViewById(R.id.input_name);
        etlastname = (EditText) findViewById(R.id.lastName);
        etemail = (EditText) findViewById(R.id.email);
        etphone = (EditText) findViewById(R.id.phone);
        etmpesaid = (EditText) findViewById(R.id.mpesa);
        etamount = (EditText) findViewById(R.id.input_amount);

       Log.d("TAG","firsname");

        Button button = (Button) findViewById(R.id.btndonate);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        PD.show();
        firstname = etfirstname.getText().toString();
        lastname = etlastname.getText().toString();
        email = etemail.getText().toString();
        phone = etphone.getText().toString();
        mpesaid = etmpesaid.getText().toString();
        amount = etamount.getText().toString();

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        PD.dismiss();
                        etfirstname.setText("");
                        Log.d("TAG" ,"error messages");
                        Toast.makeText(getApplicationContext(),"success",
                                Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                PD.dismiss();
                Log.d("TAG", "phone" );
                Toast.makeText(getApplicationContext(),error.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("firstname",firstname);
                params.put("lastname",lastname);
                params.put("email",email);
                params.put("phone",phone);
                params.put("donationid",mpesaid);
                params.put("amount",amount);

                Log.d("TAG", "mpesaid");

                return params;
            }
        };

        // Adding request to request queue
        VolleyApplication.getInstance().addToReqQueue(postRequest);
    }

}







