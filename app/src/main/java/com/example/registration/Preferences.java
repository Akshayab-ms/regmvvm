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


    public EditText getUsername() {
        return username;
    }

    public EditText getMail() {
        return mail;
    }

    public EditText getPhone() {
        return phone;
    }

    public EditText getPassword() {
        return password;
    }

    public EditText getConfirmpwd() {
        return confirmpwd;
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public Button getButtonreg() {
        return buttonreg;
    }

    public void setUsername(EditText username) {
        this.username = username;
    }

    public void setMail(EditText mail) {
        this.mail = mail;
    }

    public void setPhone(EditText phone) {
        this.phone = phone;
    }

    public void setPassword(EditText password) {
        this.password = password;
    }

    public void setConfirmpwd(EditText confirmpwd) {
        this.confirmpwd = confirmpwd;
    }

    public void setPreferences(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public void setButtonreg(Button buttonreg) {
        this.buttonreg = buttonreg;
    }

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


}