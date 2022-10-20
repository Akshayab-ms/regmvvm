package com.example.registration.ViewModel;

import static android.content.Context.MODE_PRIVATE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;

import com.example.registration.Preferences;

public class RegistrationViewModel extends AndroidViewModel {
   public MutableLiveData<String> createNewUserLiveData = new MutableLiveData<>();


    public RegistrationViewModel(@NonNull Application application) {
        super(application);

    }




    }



