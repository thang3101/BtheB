package com.example.btheb;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Language extends AppCompatActivity {

Button btnEnglish, btnVietnamese;
ImageView imvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_language);

        LinkViews();
        AddEvents();
    }

    private void LinkViews() {
        btnEnglish = findViewById(R.id.btnEnglish);
        btnVietnamese = findViewById(R.id.btnVietnamese);
        imvBack = findViewById(R.id.imvBack);
    }

    private void AddEvents() {
        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEnglish.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.tick, 0);
                btnEnglish.setTypeface(null, Typeface.BOLD);
                btnVietnamese.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
                btnVietnamese.setTypeface(null, Typeface.NORMAL);
            }
        });

        btnVietnamese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnVietnamese.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.tick, 0);
                btnVietnamese.setTypeface(null,Typeface.BOLD);
                btnEnglish.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
                btnEnglish.setTypeface(null, Typeface.NORMAL);
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