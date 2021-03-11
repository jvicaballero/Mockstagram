package com.example.mockstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    public static final String TAG = "SignupActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

//        if(ParseUser.getCurrentUser() != null) {
//            goMainActivity();
//        }

        etUsername = findViewById(R.id.usernameSignup);
        etPassword = findViewById(R.id.passwordSignup);
        btnSignup = findViewById(R.id.signupBtn);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick signup button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                signupUser(username, password);
            }
        });
    }

    private void signupUser(String username, String password) {
        Log.i(TAG, "Attempting to signup new user " + username);

        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if( e != null){
                    Log.e(TAG, "Issue with login", e);
                    Toast.makeText(SignUpActivity.this, "Invalid Username Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                goLoginActivity();
                Toast.makeText(SignUpActivity.this,"Success!" , Toast.LENGTH_SHORT);
            }
        });
    }

   private void goLoginActivity() {
        Intent i = new Intent( this , LoginActivity.class);
       startActivity(i);
      finish();
    }
}
