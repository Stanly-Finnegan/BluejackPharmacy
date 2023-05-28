package com.example.project_mcs_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {


    private ArrayList<UserData> mUser;

    EditText name, email, password;

    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        name = findViewById(R.id.input_register_name);
        email = findViewById(R.id.input_register_email);
        password = findViewById(R.id.input_register_password);

        login = findViewById(R.id.btn_register_login);
        register = findViewById(R.id.btn_register_register);

        mUser = new ArrayList<>();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntentLogin = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(myIntentLogin);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(name.getText().toString())){
                    name.setError("this filed cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(email.getText().toString())){
                    email.setError("this filed cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(password.getText().toString())){
                    password.setError("this filed cannot be empty");
                    return;
                }


                mUser.add(new UserData(name.getText().toString(),email.getText().toString(),password.getText().toString()));


                Intent myIntentRegister =new Intent(getBaseContext(), LoginActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("Arraylist", mUser);
                myIntentRegister.putParcelableArrayListExtra("Arraylist", mUser);
                startActivity(myIntentRegister);
            }
        });







    }
}