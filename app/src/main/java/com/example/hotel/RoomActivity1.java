package com.example.hotel;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RoomActivity1 extends AppCompatActivity {
    Button book;
    EditText checkindate,checkoutdate,numberofadults,hotel;
    RadioButton radioButton;
    RadioGroup radioGroup;
    String Checkin,Checkout,Noofadults,Typeofroom,hotelname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);
        book = (Button) findViewById(R.id.btnbook);
        checkindate = (EditText)findViewById(R.id.etcheckindate);
        checkoutdate=(EditText)findViewById(R.id.etcheckoutdate);
        numberofadults=(EditText)findViewById(R.id.etadult);
        hotel = (EditText) findViewById(R.id.hotelname);
        radioGroup = (RadioGroup) findViewById(R.id.rgtype);
        radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        Checkin = checkindate.getText().toString();
        Checkout = checkoutdate.getText().toString();
        Noofadults = numberofadults.getText().toString();
        Typeofroom = radioButton.getText().toString();
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adddata();
                startActivity(new Intent(RoomActivity1.this, RatingActivity.class));
            }
        });
    }
    public void adddata(){
        final String Checkin = checkindate.getText().toString().trim();
        final String  Checkout = checkoutdate.getText().toString();
        final String Noofadults = numberofadults.getText().toString().trim();
        radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        Typeofroom = radioButton.getText().toString();
        final String typeofroom = radioButton.getText().toString();
        final String hotelname = hotel.getText().toString();
        int adults= Integer.parseInt(Noofadults);
        int value=0;
        //Toast.makeText(RoomActivity.this,typeofroom,Toast.LENGTH_SHORT).show();
        if(typeofroom.equals("AC")){
            value=1;
        }
        Toast.makeText(RoomActivity1.this,"Your Bill is :"+Integer.toString((adults*1250)+(value*1500)), Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.URL_register_room,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {
                        //  SharedPrefsMethods.saveprofiledata("Logined",email,mobile,spinner,name);


                        Toast.makeText(RoomActivity1.this,ServerResponse,Toast.LENGTH_LONG).show();

                        // Hiding the progress dialog after all task complete.





                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.


                        // Showing error message if something goes wrong.
                        Toast.makeText(RoomActivity1.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The first argument should be same sa your MySQL database table columns.
                params.put(Config.checkindate,Checkin);
                params.put(Config.checkoutdate,Checkout);
                params.put(Config.numberofadults,Noofadults);
                params.put(Config.typeofroom,typeofroom);
                params.put(Config.hotelname,hotelname);
                if(typeofroom.equals("AC"))
                    params.put(Config.hotelimage,Config.acimage);
                else
                    params.put(Config.hotelimage,Config.nonacimage);
                //  params.put("User_Password", PasswordHolder);

                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);


    }
}
