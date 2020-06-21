package com.example.hotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class customer_login extends AppCompatActivity {
    Button signup, login;
    EditText editText_email, editText_pass;
    String string_email, string_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        signup = (Button) findViewById(R.id.btnsignup);
        login = (Button) findViewById(R.id.btnsignin);
        editText_email = (EditText)findViewById(R.id.etemail);
        editText_pass = (EditText)findViewById(R.id.etpassword);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(customer_login.this,customer_signup.class));
            }
        })
        ;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string_email = editText_email.getText().toString().trim();
                string_password = editText_pass.getText().toString().trim();
                if(string_email.equals("")||string_password.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter email or password",Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(customer_login.this, RoomActivity1.class));
                }
                }
        });
    }

}


