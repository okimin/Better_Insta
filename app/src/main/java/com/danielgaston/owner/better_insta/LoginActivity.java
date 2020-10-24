package com.danielgaston.owner.better_insta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG= "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(ParseUser.getCurrentUser()!=null){
            goMainActivity();
        }
        etUsername= findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        loginBtn = findViewById(R.id.loginBtn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"Button has been clicked.");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username,password);

            }
        });
    }

    private void loginUser( String username , String password){
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e!=null){
                    Toast.makeText(LoginActivity.this,"Issue With Login",Toast.LENGTH_SHORT).show();
                    return;
                }
                goMainActivity();
                Toast.makeText(LoginActivity.this,"Lets go",Toast.LENGTH_SHORT).show();
                
            }
        });

    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}