package com.example.project_mcs_1;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private ArrayList<UserData> mUser;

    EditText email, password;

    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.input_login_email);
        password = findViewById(R.id.input_login_password);

        login = findViewById(R.id.btn_login_login);
        register = findViewById(R.id.btn_login_register);


        Intent getIntent = getIntent();
        mUser = getIntent.getParcelableArrayListExtra("Arraylist");



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    email.setError("this filed cannot be empty");
                    return;
                }
                else{
                    for (UserData item : mUser){
                        if(item.getEmail().equals(email.getText().toString())){
                            if(item.getPassword().equals(password.getText().toString())){
                                Intent myIntentLogin =new Intent(getBaseContext(), HomeActivity.class);
                                startActivity(myIntentLogin);
                            }
                        }

                    }
                    Toast.makeText(LoginActivity.this, "Email or Password not Exists", Toast.LENGTH_SHORT).show();
                    return;

                }



//                Log.i("check","email:"+mUser.get(0).getEmail());






            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntentRegister = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(myIntentRegister);
            }
        });



    }


        boolean contains(ArrayList<UserData> list){



        return false;
        }


}