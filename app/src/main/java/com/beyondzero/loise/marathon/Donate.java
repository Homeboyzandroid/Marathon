package com.beyondzero.loise.marathon;


import android.app.ProgressDialog;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.util.Log;

import android.view.Gravity;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;


import android.app.Activity;

import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.beyondzero.loise.marathon.Adapter.VolleyApplication;



import java.util.HashMap;


import java.util.Map;


/**
 * A login screen that offers login via email/password.
 */
public class Donate extends Activity {
    EditText etfirstname, etlastname, etemail, etphone, etmpesaid, etamount;
    String url = "http://www.flhm.or.ke/api/v2/donation";
    String firstname, lastname, email, phone, mpesaid, amount;

    ProgressDialog PD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        //adding the logo on toolbar
      // getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.fl);

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
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (etfirstname.getText().toString().equals("") && etlastname.getText().toString().equals("")
                        && etemail.getText().toString().equals("") && etphone.getText().toString().equals("")
                        && etmpesaid.getText().toString().equals("") && etamount.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "No detail entered", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (etfirstname.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "enter first name", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (etlastname.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "enter last name", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (etemail.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "please enter email address", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (etphone.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "please enter phone number", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (etmpesaid.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "please enter transaction id", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (etamount.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "please enter how much you have donated", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else {
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
                                    Log.d("TAG", "error messages");

                                    //dialog box starts here

                                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Donate.this);
                                    alertDialogBuilder.setTitle("Donation Successful.");
                                    alertDialogBuilder.setMessage("Your donation for the First Lady Marathon 2016 was recieved thank you.\n" +
                                            "\n" +
                                            "For any queries and support reach us on:\n" +
                                            "\n" +
                                            "Email: info@beyondzero.or.ke\n" +
                                            "\n" +
                                            "Tel: +254 0703991991 or0707991991");

                                    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                            //  Toast.makeText(RegisterActivity.this, "Thank you", Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        }
                                    });

                                    AlertDialog alertDialog = alertDialogBuilder.create();
                                    alertDialog.show();
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                                }
                            }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(Donate.this,"no internet connection try later",Toast.LENGTH_LONG).show();


                            PD.dismiss();


                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("firstname", firstname);
                            params.put("lastname", lastname);
                            params.put("email", email);
                            params.put("phone", phone);
                            params.put("donationid", mpesaid);
                            params.put("amount", amount);
                            Log.d("TAG", "mpesaid");

                            return params;
                        }
                    };


                    // Adding request to request queue
                    VolleyApplication.getInstance().addToReqQueue(postRequest);

                }
            }
        });
    }



}







