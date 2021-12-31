package com.example.btheb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.TrackOrderAdapter;
import com.example.model.Order_Detail;

import java.util.ArrayList;

public class Track_My_Order extends AppCompatActivity {


    ListView lvOrder;
    ArrayList<Order_Detail> items;
    TrackOrderAdapter adapter;
    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trackmyorder);

        linkView();
        loadData();
        addEvents();
    }

    private void linkView() {
        lvOrder = findViewById(R.id.lvTrackOrders);
        btnBack = findViewById(R.id.imvBack);
    }

    private void loadData() {
        items = new ArrayList<Order_Detail>();
        items.add(new Order_Detail(R.drawable.sneaker1,"Ultraboost 29 Shoes","Fashion shoes",170.0,1,"To recieve"));
        items.add(new Order_Detail(R.drawable.sneaker2,"McKenzie Treso 2","Fashion shoes",190.0,2,"Processing"));
        items.add(new Order_Detail(R.drawable.sneaker3,"Nike Air Max 2021","Fashion shoes",150.0,1,"Completed"));

        adapter = new TrackOrderAdapter(this, R.layout.item_trackmyorder_layout, items);
        lvOrder.setAdapter(adapter);
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        lvOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(Track_My_Order.this,Track_order_Details.class));
            }
        });
    }
}