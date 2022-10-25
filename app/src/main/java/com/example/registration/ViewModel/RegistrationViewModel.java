package com.example.registration.ViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationViewModel extends AndroidViewModel {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private Preferences prefm;
   public MutableLiveData<String> createNewUserLiveData = new MutableLiveData<String>();
    public MutableLiveData<String> mailLiveData = new MutableLiveData<String>();
    public MutableLiveData<String> phoneLiveData = new MutableLiveData<String>();
    public MutableLiveData<String> passwordLiveData = new MutableLiveData<String>();
   public RegistrationViewModel(@NonNull Application application) {
        super(application);
   }

    public MutableLiveData<String> getcreateNewUserLiveData(){
        return createNewUserLiveData;
    }
    public  MutableLiveData<String> getMailLiveData(){
       return mailLiveData;
    }
    public  MutableLiveData<String> getPhoneLiveData(){
        return phoneLiveData;
    }
    public  MutableLiveData<String> getPasswordLiveData(){
        return passwordLiveData;
    }





    SharedPreferences sharedpreferences = getApplication().getSharedPreferences("pref_key", Context.MODE_PRIVATE);


        String varName = sharedpreferences.getString("username", "");
        String varMail = sharedpreferences.getString("mail","");
        String varPhone = sharedpreferences.getString("phone", "");
      String varPwd = sharedpreferences.getString("password","");
        String varCpwd = sharedpreferences.getString("confipwd","");



    public boolean checkUserInputDetails(){

        if(!fcPhone(varPhone)){
            phoneLiveData.setValue("Phone not match");
        }else if(!fcMail(varMail)){
            mailLiveData.setValue("Mail not match");
        }
        else if(!fcpwd(varPwd,varName)) {
            createNewUserLiveData.setValue("password not match");
            passwordLiveData.setValue("jh");
        }
        else if(!fcpwd(varCpwd,varName)){
            passwordLiveData.setValue("cnfpassword should be same as password");
        }


        return false;
    }


    public  boolean fcPhone(String varPhone){
       this.varPhone=varPhone;
       phoneLiveData.postValue(varPhone);

       if (varPhone.matches("\\d{10}"))
               return true;
           else if (varPhone.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
               return true;
           else if (varPhone.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))
               return true;

           else if (varPhone.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
               return true;
           else if (varPhone.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
               return true;
           else if (varPhone.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))
               return true;
           else if (varPhone.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))
               return true;
           else
               return false;



   }
   public boolean fcMail(String varMail){
       this.varMail=varMail;
       mailLiveData.postValue(varMail);
       Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(varMail);

       return matcher.find();
   }


    public boolean fcpwd(String userName, String password)
    {
        password=varPwd;
        userName=varName;
        boolean valid = true;
        passwordLiveData.postValue(varPwd);
        createNewUserLiveData.postValue(varName);
        if (password.length() > 15 || password.length() < 8)
        {
            System.out.println("Password should be less than 15 and more than 8 characters in length.");
            valid = false;
        }
        if (password.indexOf(userName) > -1)
        {
            System.out.println("Password Should not be same as user name");
            valid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars ))
        {
            System.out.println("Password should contain atleast one upper case alphabet");
            valid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars ))
        {
            System.out.println("Password should contain atleast one lower case alphabet");
            valid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers ))
        {
            System.out.println("Password should contain atleast one number.");
            valid = false;
        }
        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        if (!password.matches(specialChars ))
        {
            System.out.println("Password should contain atleast one special character");
            valid = false;
        }
        if (valid)
        {
            System.out.println("Password is valid.");
        }


        return valid;
    }







    }










