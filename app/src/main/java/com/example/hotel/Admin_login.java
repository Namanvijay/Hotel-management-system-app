package com.example.hotel;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_login extends AppCompatActivity {
    Button login;
    EditText admin_name,admin_password;
    String pass,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        admin_name = (EditText) findViewById(R.id.etemail);
        admin_password = (EditText) findViewById(R.id.etpassword);




    login = (Button) findViewById(R.id.adminsignin);
    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            name = admin_name.getText().toString();
            pass = admin_password.getText().toString();
//            Toast.makeText(getApplicationContext(),name + "=="+ pass,Toast.LENGTH_SHORT).show();
            if(name.equals("abc@gmail.com")&& pass.equals("123456")){

                startActivity(new Intent(Admin_login.this,customer_hotel_list.class));
            }
            else{
                Toast.makeText(Admin_login.this,"Enter correct credentials", Toast.LENGTH_SHORT).show();
            }
            //startActivity(new Intent(Admin_login.this,customer_hotel_list.class));
        }
    });
    }

}

