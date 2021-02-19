package com.gtech.foodipsdelivery.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.gtech.foodipsdelivery.R;
import com.gtech.foodipsdelivery.api.ApiClient;
import com.gtech.foodipsdelivery.api.ApiInterface;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    //Creating Initialization for Components
    TextInputEditText getUserName;
    TextInputEditText getPassword;

    //Creating Variable declarations
    String username = "";
    String password = "";

    //Retrofit
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void DeliveryBoyLogin(View view) {

        getUserName = findViewById(R.id.username);
        getPassword = findViewById(R.id.password);

        username = Objects.requireNonNull(getUserName.getText()).toString();
        password = Objects.requireNonNull(getPassword.getText()).toString();

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBody> call = ApiClient.getClient().create(ApiInterface.class)
                .LoginUser(username, password);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                assert response.body() != null;
                if (response.body().toString().equals("success")) {
                    Toast.makeText(LoginActivity.this, "Sucess", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}