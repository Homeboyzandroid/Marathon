package com.beyondzero.loise.marathon;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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

public class RegisterActivity extends AppCompatActivity {
    Spinner spinnercounty, spinnercategort,spinnertime,spinnertshirt,spinnerid;
    EditText ettransactionid,etfirstname,etlastname,etidno,etemail,etphone,etdob,etAmount,etcountry;
    EditText etnationality,etkinName,etRelationship,etKinPhone;
    CheckBox etcheckbox;
  //  RadioButton rdmale, rdfemale;
    RadioGroup radiogroupgender;

    String url = "http://www.flhm.or.ke/api/v1/registration";


    String transactionid,firstname,lastname,idno,email,phone,dob,Amount,country,nationality,Kinname,Relationship,Kinphone;
    String county,category,tshirt,time,radiogroup,idtype;
    String checkbox;

   // AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

    ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.fl);

      // instances of values

        PD = new ProgressDialog(this);
        PD.setMessage("Loading.....");
        PD.setCancelable(false);

        ettransactionid = (EditText)findViewById(R.id.input_traid);
        etfirstname = (EditText)findViewById(R.id.etfirstname);
        etlastname = (EditText)findViewById(R.id.etlastName);
        etidno = (EditText)findViewById(R.id.idnumber);
        etemail = (EditText)findViewById(R.id.email);
        etphone = (EditText)findViewById(R.id.etphone);
        etdob = (EditText)findViewById(R.id.dob);
        etAmount = (EditText)findViewById(R.id.etamount);
        etcountry = (EditText)findViewById(R.id.etcountry);
        etnationality = (EditText)findViewById(R.id.etnationality);
        etkinName = (EditText)findViewById(R.id.nextofkin);
        etRelationship = (EditText)findViewById(R.id.etrelationship);
        etKinPhone = (EditText)findViewById(R.id.kinphone);

        //checbox instantiation
        etcheckbox=(CheckBox)findViewById(R.id.checkBox);

        //Radio button instantiation
        radiogroupgender = (RadioGroup)findViewById(R.id.radiogroup);


        //spinner instantiation
        spinnercounty = (Spinner)findViewById(R.id.spinnercounty);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.county, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercounty.setAdapter(adapter1);

        spinnercategort = (Spinner)findViewById(R.id.spinnercategory);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercategort.setAdapter(adapter);

        spinnertime = (Spinner)findViewById(R.id.spinnertime);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.time, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertime.setAdapter(adapter2);

        spinnertshirt = (Spinner)findViewById(R.id.spinnertshirt);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.tshirts, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertshirt.setAdapter(adapter3);

        spinnerid = (Spinner)findViewById(R.id.spinneridtype);
        ArrayAdapter<CharSequence>adapter4 = ArrayAdapter.createFromResource(this,
                R.array.idtype,android.R.layout.simple_spinner_dropdown_item);
        spinnerid.setAdapter(adapter4);




        Button buttonprev= (Button)findViewById(R.id.btn_prev);
        buttonprev.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Ok!!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, RegistrationInfo.class);
                startActivity(intent);
                finish();
            }
        });

        Button buttonnext= (Button)findViewById(R.id.btnnext);
        buttonnext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ettransactionid.getText().toString().equals("") && etfirstname.getText().toString().equals("") && etlastname.getText().toString().equals("")
                        && etemail.getText().toString().equals("") && etphone.getText().toString().equals("")
                        && etdob.getText().toString().equals("") && etAmount.getText().toString().equals("")
                        && etcountry.getText().toString().equals("") && etnationality.getText().toString().equals("")
                        && etkinName.getText().toString().equals("") && etRelationship.getText().toString().equals("") && etKinPhone.getText().toString().equals("")
                        && spinnercategort.getSelectedItem().toString().equals("") && spinnercounty.getSelectedItem().toString().equals("") && spinnertime.getSelectedItem().toString().equals("")
                        && spinnertshirt.getSelectedItem().toString().equals("") && radiogroupgender.getCheckedRadioButtonId() == -1) {
                    Toast toast = Toast.makeText(getApplicationContext(), "No detail entered", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (ettransactionid.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "please enter MPESA transaction id", Toast.LENGTH_SHORT);
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
                } else if (etdob.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "enter date of birth", Toast.LENGTH_SHORT);
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
                } else if (etAmount.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "amount should be 1500 ksh", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (etcountry.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "your country please", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (etnationality.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nationality please", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (etkinName.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "next of kin please", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (etRelationship.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "relationship please", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (etKinPhone.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "please enter next of kin phone", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (spinnercategort.getSelectedItem().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "enter marathon category", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (spinnercounty.getSelectedItem().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "your county please", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (spinnertshirt.getSelectedItem().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "enter tshirt size", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (spinnertime.getSelectedItem().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "your best time please", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }else if (etcheckbox.isChecked()==false){
                    Toast toast=Toast.makeText(getApplicationContext(),"Accept the terms and conditions", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
//                } else if (radiogroupgender.getCheckedRadioButtonId() == -1) {
//                    Toast toast = Toast.makeText(getApplicationContext(), "select gender", Toast.LENGTH_SHORT);
//                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
//                    toast.show();
                } else {
                    PD.show();

                    transactionid = ettransactionid.getText().toString();
                    firstname = etfirstname.getText().toString();
                    lastname = etlastname.getText().toString();
                    idno = etidno.getText().toString();
                    email = etemail.getText().toString();
                    phone = etphone.getText().toString();
                    dob = etdob.getText().toString();
                    Amount = etAmount.getText().toString();
                    country = etcountry.getText().toString();
                    nationality = etnationality.getText().toString();
                    Kinname = etkinName.getText().toString();
                    Relationship = etRelationship.getText().toString();
                    Kinphone = etKinPhone.getText().toString();
                    county = spinnercounty.getSelectedItem().toString();
                    category = spinnercategort.getSelectedItem().toString();
                    tshirt = spinnertshirt.getSelectedItem().toString();
                    idtype = spinnerid.getSelectedItem().toString();
                    time = spinnertime.getSelectedItem().toString();
                    Integer id = radiogroupgender.getId();
                    radiogroup = id.toString();

                    Integer checkid=etcheckbox.getId();
                    checkbox=checkid.toString();



                    Log.d("TAG", "just before toString()");

                    StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {

                                @Override
                                public void onResponse(String response) {
                                    PD.dismiss();
                                    etfirstname.setText("");
                                    Log.d("TAG", "error messages");

                                    //dialog box starts here
                                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RegisterActivity.this);
                                    alertDialogBuilder.setTitle("Registration Successful.");
                                    alertDialogBuilder.setMessage("You have successfuly registered for the First Lady Marathon 2016\n" +
                                            "\n" +
                                            "For any queries and support reach use on:\n" +
                                            "\n" +
                                            "Email: info@beyondzero.or.ke\n" +
                                            "\n" +
                                            "Tel: +254 0703991991 or0707991991");

                                    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                            //  Toast.makeText(RegisterActivity.this, "Thank you", Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                            RegisterActivity.this.startActivity(intent);
                                           // startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        }
                                    });

                                    AlertDialog alertDialog = alertDialogBuilder.create();
                                    alertDialog.show();

                                    /*Toast.makeText(getApplicationContext(), "success",
                                            Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));*/

                                }
                            }, new Response.ErrorListener() {

                        @Override
                            public void onErrorResponse(VolleyError error) {
                                if (error instanceof NetworkError) {
                                    try {
                                        Toast.makeText(getApplicationContext(),
                                                "Network Error. Try Again Later",
                                                Toast.LENGTH_SHORT).show();
                                    } catch (NullPointerException npe) {
                                        System.err.println(npe);
                                    }
                                } else if (error instanceof ServerError) {
                                    try {
                                        // dialog box starts here
                                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RegisterActivity.this);
                                        alertDialogBuilder.setTitle("Registration Successful.");
                                        alertDialogBuilder.setMessage("You have successfuly registered for the First Lady Marathon 2016\n" +
                                                "\n" +
                                                "For any queries and support reach use on:\n" +
                                                "\n" +
                                                "Email: info@beyondzero.or.ke\n" +
                                                "\n" +
                                                "Tel: +254 0703991991 or0707991991");

                                        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface arg0, int arg1) {
                                              //  Toast.makeText(RegisterActivity.this, "Thank you", Toast.LENGTH_LONG).show();
                                                //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                                RegisterActivity.this.startActivity(intent);
                                            }
                                        });

                                        AlertDialog alertDialog = alertDialogBuilder.create();
                                        alertDialog.show();
                                    } catch (NullPointerException npe) {
                                        System.err.println(npe);
                                    }
                                } else if (error instanceof AuthFailureError) {
                                } else if (error instanceof ParseError) {
                                } else if (error instanceof NoConnectionError) {
                                    try {
                                        Toast.makeText(getApplicationContext(),
                                                "No Connection", Toast.LENGTH_SHORT).show();
                                    } catch (NullPointerException npe) {
                                        System.err.println(npe);
                                    }
                                } else if (error instanceof TimeoutError) {
                                    try {
                                        Toast.makeText(
                                                getApplicationContext().getApplicationContext(),
                                                "Timeout Error. Try Again Later",
                                                Toast.LENGTH_SHORT).show();
                                    } catch (NullPointerException npe) {
                                        System.err.println(npe);
                                    }
                                }


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
                            params.put("nationalid", idno);
                            params.put("idtype", idtype);
                            params.put("dob", dob);
                            params.put("marathon", category);
                            params.put("gender", radiogroup);
                            params.put("nationality", nationality);
                            params.put("residence", country);
                            params.put("county", county);
                            params.put("bestime", time);
                            params.put("tshirt", tshirt);
                            params.put("name", Kinname);
                            params.put("relationship", Relationship);
                            params.put("phone3", Kinphone);
                            params.put("mpesaid", transactionid);
                            //params.put("amount",Amount);

                            Log.d("TAG", "mpesaid");

                            return params;
                        }

                         @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            // Removed this line if you dont need it or Use application/json
                             //params.put("Content-Type", "application/x-www-form-urlencoded");
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
