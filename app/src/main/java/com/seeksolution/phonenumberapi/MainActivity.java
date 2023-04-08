package com.seeksolution.phonenumberapi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.seeksolution.phonenumberapi.Api.RetrofitClient;
import com.seeksolution.phonenumberapi.Model.ContactModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText number;
     Button btn1;
     String number2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        number = findViewById(R.id.number);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number2 = number.getText().toString();

                if (number2.isEmpty()){
                    number.setError("");
                    number.requestFocus();
                }else{
                    Call<ContactModel> call = RetrofitClient.getInstance().getApi().getUSer(number2);
                    call.enqueue(new Callback<ContactModel>() {
                        @Override
                        public void onResponse(Call<ContactModel> call, Response<ContactModel> response) {
                          ContactModel contactModel = response.body();
                          String res = contactModel.getMessage();

                          if (res.equals("Inserted")){

                              Toast.makeText(MainActivity.this, "Number Inserted", Toast.LENGTH_SHORT).show();
                              Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                              intent.putExtra("number",number2);
                              startActivity(intent);
                              finish();
                          }

                          if (res.equals("failed")){
                              Toast.makeText(MainActivity.this, "Already exist data", Toast.LENGTH_SHORT).show();
                          }
                        }

                        @Override
                        public void onFailure(Call<ContactModel> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "failed Not Inerted data", Toast.LENGTH_SHORT).show();

                        }
                    });
                }


            }
        });
    }
}