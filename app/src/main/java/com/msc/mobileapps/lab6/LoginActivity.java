package com.msc.mobileapps.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(v -> validateLoginCredentials());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void validateLoginCredentials() {
        String username = ((EditText) findViewById(R.id.username)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();

        if (!username.isEmpty() && username.equals("admin") && !password.isEmpty() && password.equals("123")) {
            Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
            myIntent.putExtra("username", username);
            LoginActivity.this.startActivity(myIntent);
        } else {
            Toast.makeText(this, "Wrong username and/or password", Toast.LENGTH_LONG).show();
        }
    }
}