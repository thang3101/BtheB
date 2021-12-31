package com.example.btheb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class BrandActivity extends AppCompatActivity {
    ListView lvBrands;
    ImageView imvBack;
    EditText edtSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);
        linkViews();
        inputDataLv();
        addEvents();
    }


    private void linkViews() {
        lvBrands = findViewById(R.id.lvBrands);
        imvBack = findViewById(R.id.imvBack);
        edtSearch = findViewById(R.id.edtSearch);
    }

    private void inputDataLv() {
        String[] arrayList = {"Adidas","Alexander McQueen","Asics","Balenciaga","Burberry","Brookhaven","Calvin Klein","Converse","Champion","Degrey","Dirty Coins","Dior","Dolce Gabbana"};
        ArrayAdapter adapter = new ArrayAdapter(BrandActivity.this, android.R.layout.simple_list_item_1, arrayList);
        lvBrands.setAdapter(adapter);
    }

    private void addEvents() {
        lvBrands.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(BrandActivity.this, com.example.btheb.All_product.class));
            }
        });

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BrandActivity.this, com.example.btheb.Search_keyword.class));
            }
        });
    }

}