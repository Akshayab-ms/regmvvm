package com.example.registration;

import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.registration.ViewModel.RegistrationViewModel;

public class LoginActivity extends Preferences {
    TextView phone,password;
    Button loginbtn;
    Preferences prm;
    RegistrationViewModel registrationViewModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone=findViewById(R.id.edt_phone);
        password=findViewById(R.id.edt_pwd);
        loginbtn=findViewById(R.id.button_login);

        preferences = getSharedPreferences("Userinfo", 0);

        registrationViewModel.getCreateUserObserver();
//        boolean ispass=false;
//        ispass=registrationViewModel.passwordValidation();



        registrationViewModel.emailValidation.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

                showAlertDialog(s);
            }
        });

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

    private void showAlertDialog(String s) {


    }
}