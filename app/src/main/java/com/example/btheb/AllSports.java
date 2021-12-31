package com.example.btheb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.AllSportAdapter;
import com.example.model.AllSportsModel;

import java.util.ArrayList;

public class AllSports  extends AppCompatActivity {

    GridView gvAllSports;
    ArrayList<AllSportsModel> items;
    AllSportAdapter adapter;
    ImageView imvBack;
    EditText edtSearch;
    Button btnShop,btnOpenshop;
        @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_sports);
            linkViews();
            inputDataLv();
            addEvents();
    }
        private void linkViews() {
            gvAllSports = findViewById(R.id.gvAllSports);
            imvBack = findViewById(R.id.imvBack);
            edtSearch = findViewById(R.id.edtSearch);
            btnShop = findViewById(R.id.btnShopNow);
            btnOpenshop = findViewById(R.id.btnOpenShop);
    }

        private void inputDataLv() {
            items =new ArrayList<>();
            items.add(new AllSportsModel(R.drawable.fitness,"Fitness"));
            items.add(new AllSportsModel(R.drawable.running,"Running"));
            items.add(new AllSportsModel(R.drawable.boxing,"Boxing"));
            items.add(new AllSportsModel(R.drawable.baseball,"Baseball"));
            items.add(new AllSportsModel(R.drawable.swimming,"Swimming"));
            items.add(new AllSportsModel(R.drawable.soccer,"Soccer"));
            items.add(new AllSportsModel(R.drawable.football,"Football"));
            items.add(new AllSportsModel(R.drawable.basketball,"Basketball"));
            items.add(new AllSportsModel(R.drawable.volleyball,"Volleyball"));
            items.add(new AllSportsModel(R.drawable.hiking,"Hiking"));
            items.add(new AllSportsModel(R.drawable.tennis,"Tennis"));
            items.add(new AllSportsModel(R.drawable.all,"Shop All"));

            adapter = new AllSportAdapter(AllSports.this,R.layout.item_allsports_layout, items);
            gvAllSports.setAdapter(adapter);
    }

        private void addEvents() {
            imvBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            edtSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(AllSports.this, com.example.btheb.Search_keyword.class));
                }
            });

            btnShop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(AllSports.this, com.example.btheb.All_product.class));
                }
            });
            btnOpenshop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(AllSports.this, com.example.btheb.All_product.class));
                }
            });
    }
}