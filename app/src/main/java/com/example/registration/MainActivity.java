package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registration.ViewModel.RegistrationViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity {
    RegistrationViewModel viewModel;
    TextInputLayout layoutName, layoutMail, layoutPhone, layoutPassword, layoutconfirmpwd;

    TextInputEditText username, mail, phone, password, confirmpwd;
    SharedPreferences preferences;
    Button buttonreg;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutName = findViewById(R.id.name_layout);
        layoutMail = findViewById(R.id.mail_layout);
        layoutPassword = findViewById(R.id.pwd_layout);
        layoutPhone = findViewById(R.id.layout_phone);

        layoutconfirmpwd = findViewById(R.id.layout_cnf);


        username = findViewById(R.id.edt_name);
        mail = findViewById(R.id.edt_mail);
        phone = findViewById(R.id.edt_phone);
        password = findViewById(R.id.edt_pwd);
        confirmpwd = findViewById(R.id.edt_cnf);
        buttonreg = findViewById(R.id.button_sub);
        initViewModel();

        viewModel.createNewUserLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String name) {
                username.setText(name);
            }
        });
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
        viewModel.mailLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String ma) {
                mail.setText(ma);
            }
        });





        preferences = getSharedPreferences("Userinfo", 0);

        buttonreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernamevalue = username.getText().toString();
                String mailvalue = mail.getText().toString();
                String phonevalue = phone.getText().toString();
                String passwordvalue = password.getText().toString();
                String confirmpvalue = confirmpwd.getText().toString();


                if(viewModel.checkUserInputDetails() == true){




                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", usernamevalue);
                editor.putString("mail", mailvalue);
                editor.putString("phone", phonevalue);
                editor.putString("password", passwordvalue);
                editor.putString("confipwd", confirmpvalue);
                editor.apply();
                Toast.makeText(MainActivity.this, "user registered", Toast.LENGTH_SHORT).show();


                username.setText("");
                mail.setText("");
                phone.setText("");
                password.setText("");
                confirmpwd.setText("");

                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);


            }else {
                    Toast.makeText(MainActivity.this, "enter valid details", Toast.LENGTH_SHORT).show();
                }
                }

        });


    }


    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
        viewModel.getcreateNewUserLiveData();
        viewModel.getPasswordLiveData();
        viewModel.getMailLiveData();
        viewModel.getPhoneLiveData();

    }
}







