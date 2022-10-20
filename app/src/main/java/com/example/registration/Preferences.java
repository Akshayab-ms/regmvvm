package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Preferences extends AppCompatActivity {
    EditText username,mail,phone,password,confirmpwd;
    SharedPreferences preferences;
    Button buttonreg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.edt_name);
        mail=findViewById(R.id.edt_mail);
        phone=findViewById(R.id.edt_phone);
        password=findViewById(R.id.edt_pwd);
        confirmpwd=findViewById(R.id.edt_cnf);
        buttonreg=findViewById(R.id.button_sub);


        preferences  = getSharedPreferences("Userinfo", 0);

        buttonreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernamevalue=username.getText().toString();
                String mailvalue=mail.getText().toString();
                String phonevalue=phone.getText().toString();
                String passwordvalue=password.getText().toString();
                String confirmpvalue=confirmpwd.getText().toString();


                SharedPreferences.Editor editor =preferences.edit();
                editor.putString("username",usernamevalue);
                editor.putString("mail",mailvalue);
                editor.putString("phone",phonevalue);
                editor.putString("password",passwordvalue);
                editor.putString("confipwd",confirmpvalue);
                editor.apply();


                username.setText("");
                mail.setText("");
                phone.setText("");
                password.setText("");
                confirmpwd.setText("");


            }
        });




    }
//    public void emptyField(){
//        username.setText("");
//        mail.setText("");
//        phone.setText("");
//        password.setText("");
//        confirmpwd.setText("");
//
//    }
}