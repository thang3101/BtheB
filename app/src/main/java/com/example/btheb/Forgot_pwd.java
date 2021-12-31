package com.example.btheb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Forgot_pwd extends AppCompatActivity {

    Button btnReset;
    ImageView imvBack;
    EditText edtName, edtPhone, edtMail, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);

        LinkViews();
        AddEvents();
    }

    private void LinkViews() {
        btnReset = findViewById(R.id.btnResetPW);
        imvBack = findViewById(R.id.imvBack);
        edtMail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPassword);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
    }

    private void AddEvents() {
        btnReset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (edtMail.getText().length() == 0 || edtName.getText().length() == 0 || edtPass.getText().length() == 0 || edtPhone.getText().length() == 0 )
                Toast.makeText(Forgot_pwd.this, "You must fill in all the information to signing up!", Toast.LENGTH_SHORT).show();
            else startActivity(new Intent(Forgot_pwd.this,SignIn.class));
        }
    });

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}