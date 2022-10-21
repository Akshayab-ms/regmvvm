package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registration.ViewModel.RegistrationViewModel;

public class MainActivity extends AppCompatActivity {
    RegistrationViewModel viewModel;
    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







    }
    private void initViewModel(){
        viewModel =new ViewModelProvider(this).get(RegistrationViewModel.class);
        viewModel.getCreateUserObserver();
    }





    }



