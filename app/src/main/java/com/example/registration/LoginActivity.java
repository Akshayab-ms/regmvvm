package com.example.registration;

import androidx.lifecycle.Observer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.registration.ViewModel.RegistrationViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.prefs.Preferences;

public class LoginActivity extends MainActivity {
    TextInputLayout layoutphone,layoutpwd;
    TextInputEditText phone,password;
    Button loginbtn;
    SharedPreferences preferences;
    Preferences prm;
    RegistrationViewModel registrationViewModel;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        layoutphone=findViewById(R.id.layout_ph);
        layoutpwd=findViewById(R.id.layout_pwd);
        phone=findViewById(R.id.edt_phone);
        password=findViewById(R.id.edt_pwd);
        loginbtn=findViewById(R.id.button_login);

        preferences  = getSharedPreferences("Userinfo", 0);






        viewModel.passwordLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String pwd) {
                password.setText(pwd);
                confirmpwd.setText(pwd);
            }
        });
        viewModel.phoneLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String ph) {
                phone.setText(ph);
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
                        if(phonevalue.equals(regphone)&&passwordvalue.equals(regpwd)){
                            Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                            startActivity(intent);
                        }
                    }
                }
                );

    }


}