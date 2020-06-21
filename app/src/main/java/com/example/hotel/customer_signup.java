package com.example.hotel;

import android.content.Intent;
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

public class customer_signup extends AppCompatActivity {
    private EditText editText_name;
    private EditText editText_email;
    private EditText editText_mobile;
    private EditText editText_password;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    String name,email,phone,password,gender;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signup);
        editText_name = (EditText)findViewById(R.id.etname);
        editText_email = (EditText)findViewById(R.id.etemail);
        editText_mobile=(EditText)findViewById(R.id.etphone);
        editText_password=(EditText)findViewById(R.id.etpassword);

        radioGroup = (RadioGroup) findViewById(R.id.rggender);
        name= editText_name.getText().toString();
        email = editText_email.getText().toString();
        phone=editText_mobile.getText().toString();
        password=editText_password.getText().toString();
        radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        gender = radioButton.getText().toString();
        signup = (Button) findViewById(R.id.btnsignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addcustomer();
                startActivity(new Intent(customer_signup.this,RoomActivity1.class));
            }
        });
    }
    public void addcustomer(){
        final String name = editText_name.getText().toString().trim();
        final String  email = editText_email.getText().toString();
        final String phone = editText_mobile.getText().toString().trim();
        final String password = editText_password.getText().toString().trim();
        final String gender = radioButton.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.URL_Normal_Signup_Customer,//provides the URL
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {
                        //  SharedPrefsMethods.saveprofiledata("Logined",email,mobile,name);


                        Toast.makeText(customer_signup.this,ServerResponse,Toast.LENGTH_LONG).show();

                        // Hiding the progress dialog after all task complete.





                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.


                        // Showing error message if something goes wrong.
                        Toast.makeText(customer_signup.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The first argument should be same sa your MySQL database table columns.
                params.put(Config.name,name );
                params.put(Config.email,email);
                params.put(Config.phone,phone);
                params.put(Config.password,password);
                params.put(Config.gender,gender);


                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);


    }
}
