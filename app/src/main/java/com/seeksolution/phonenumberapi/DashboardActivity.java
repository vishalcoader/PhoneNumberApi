package com.seeksolution.phonenumberapi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    TextView numberget;
    String number2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

        numberget = findViewById(R.id.number_get);

        Intent intent = getIntent();
        number2= intent.getStringExtra("number");
        numberget.setText(""+number2);
    }
}