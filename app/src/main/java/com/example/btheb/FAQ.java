package com.example.btheb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.FAQ_TopicAdapter;
import com.example.model.FAQ_Topic;

import java.util.ArrayList;

public class FAQ extends AppCompatActivity {

    RecyclerView rcvTopic;
    ImageView imvBack;
    RelativeLayout rlMyorder, rlMyvoucher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        LinkViews();
        confiRecycleView();
        initData();
        addEvents();
    }


    private void LinkViews() {
        rcvTopic = findViewById(R.id.rcvTopic);
        imvBack = findViewById(R.id.imvBack);
        rlMyorder = findViewById(R.id.rlMyorder);
        rlMyvoucher = findViewById(R.id.rlMyvoucher);
    }

    private void confiRecycleView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvTopic.setLayoutManager(manager);

        rcvTopic.setHasFixedSize(true);
        rcvTopic.setItemAnimator(new DefaultItemAnimator());

    }

    private void initData() {
        ArrayList<FAQ_Topic> topics = new ArrayList<>();
        topics.add(new FAQ_Topic(R.drawable.profile,"My Account"));
        topics.add(new FAQ_Topic(R.drawable.product,"Products"));
        topics.add(new FAQ_Topic(R.drawable.truck_big,"Delivery"));

        FAQ_TopicAdapter adapter = new FAQ_TopicAdapter(getApplicationContext(), topics);
        rcvTopic.setAdapter(adapter);
    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rlMyvoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FAQ.this, com.example.btheb.My_voucher.class));
            }
        });
        rlMyorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FAQ.this, com.example.btheb.Track_My_Order.class));
            }
        });
    }
}