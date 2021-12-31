package com.example.btheb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {

    EditText edtEmail, edtPass;
    TextView tvForgotPassword;
    Button btnSignIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        linkViews();
        AddEvents();
    }
    private void linkViews() {
        edtEmail = findViewById(R.id.edtEmailSI);
        edtPass = findViewById(R.id.edtPassSI);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    private void AddEvents() {

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (edtEmail.getText().length() == 0 && edtPass.getText().length() == 0)
                        Toast.makeText(SignIn.this, "You must fill in all the information to signing up!", Toast.LENGTH_SHORT).show();
                    else startActivity(new Intent(SignIn.this, MainActivity.class));}
                });

                tvForgotPassword.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(SignIn.this, com.example.btheb.Forgot_pwd.class));
                    }
                });

                btnSignUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(SignIn.this, com.example.btheb.SignUp.class));
                    }
                });
            }
        }