package com.example.btheb;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Interface.MyMessClick;
import com.example.adapter.MessageAdapter;
import com.example.model.Messages;
import com.example.btheb.fragments.Mess1Fragment;
import com.example.btheb.fragments.Mess2Fragment;
import com.example.btheb.fragments.Mess3Fragment;

import java.util.ArrayList;

public class Message extends AppCompatActivity implements MyMessClick{

    GridView gvMessage;
    ArrayList<Messages> items;
    MessageAdapter adapter;
    ImageView imvBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        LinkViews();
        InitData();
        AddEvents();
    }

    private void LinkViews() {
        imvBack = findViewById(R.id.imvBack);
        gvMessage = findViewById(R.id.gvMessage);
    }

    private void InitData() {
        items = new ArrayList<>();
        items.add(new Messages(R.drawable.image_mess1, "PEGASUS 38 FLYEASE LIGHTING"));
        items.add(new Messages(R.drawable.image_mess2, "SHOP FOR RUNNING SHOES LIKE A PRO"));
        items.add(new Messages(R.drawable.image_mess3, "NEW FAIRIES"));
        items.add(new Messages(R.drawable.image_mess4, "WARM LIGHTWEIGHT"));
        items.add(new Messages(R.drawable.image_mess5, "PEGASUS 38 FLYEASE LIGHTING"));
        items.add(new Messages(R.drawable.image_mess6, "SHOP FOR RUNNING SHOES LIKE A PRO"));

        adapter = new MessageAdapter(this,R.layout.item_message_layout,items);
        gvMessage.setAdapter(adapter);
    }

    private void AddEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void messclick(Messages m) {
        switch (m.getMessage_Name()) {
            case "PEGASUS 38 FLYEASE LIGHTING" : getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full_message,new Mess1Fragment()).commit(); break;
            case "SHOP FOR RUNNING SHOES LIKE A PRO" : getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full_message,new Mess2Fragment()).commit(); break;
            case "NEW FAIRIES" : getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full_message,new Mess3Fragment()).commit(); break;
        }
    }

}