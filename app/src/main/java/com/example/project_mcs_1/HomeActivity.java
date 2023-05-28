package com.example.project_mcs_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Home home = new Home();
    Transaction transaction = new Transaction();

    ImageView info, logout;

    ArrayList<TransactionModel> Tdata;

    int bottomnavpage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        info = findViewById(R.id.info_home);
        logout = findViewById(R.id.logout_home);


        bottomNavigationView = findViewById(R.id.bottomnav);

        Intent getIntent = getIntent();
        bottomnavpage = getIntent.getIntExtra("bottomnavpage", 0);


        if(bottomnavpage == 0){

            getSupportFragmentManager().beginTransaction().replace(R.id.container, home).commit();
        }
        else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, transaction).commit();
        }

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.bottom_home:

                        getSupportFragmentManager().beginTransaction().replace(R.id.container, home).commit();
                        return true;
                    case R.id.bottom_transaction:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, transaction).commit();
                        return true;
                }

                return false;
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(),LoginActivity.class);
                startActivity(myIntent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(),AboutusActivity.class);
                startActivity(myIntent);
            }
        });



    }
}