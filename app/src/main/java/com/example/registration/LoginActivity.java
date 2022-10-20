package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Preferences {
    TextView phone,password;
    Button loginbtn;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone=findViewById(R.id.edt_phone);
        password=findViewById(R.id.edt_pwd);
        loginbtn=findViewById(R.id.button_login);

        preferences = getSharedPreferences("Userinfo", 0);



        loginbtn.setOnClickListener
                (new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String phonevalue=phone.getText().toString();
                        String passwordvalue=password.getText().toString();
                        String regphone=preferences.getString("","");
                        String regpwd=preferences.getString("password","");
                    }
                }
                );

    }
}