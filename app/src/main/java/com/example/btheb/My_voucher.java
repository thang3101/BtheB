package com.example.btheb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Interface.MyBtnVoucherClick;
import com.example.adapter.VoucherAdapter;
import com.example.model.Vouchers;

import java.util.ArrayList;

public class My_voucher extends AppCompatActivity implements MyBtnVoucherClick {
    TextView txtGetMore;
    ImageView imvback;
    ListView lvVouchers;
    VoucherAdapter adapter;
    ArrayList<Vouchers> vouchers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_voucher);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void linkViews() {
        txtGetMore = findViewById(R.id.txtGetMore);
        lvVouchers = findViewById(R.id.lvMyVoucher);
        imvback = findViewById(R.id.imvBack_MyVoucher);
    }

    private void initData() {
        vouchers = new ArrayList<>();
        vouchers.add(new Vouchers(R.drawable.converse,"CONVERSE","BUY 1 GET 1"));
        vouchers.add(new Vouchers(R.drawable.balenciaga,"BALENCIAGA","Sale off 10% for women items"));
        vouchers.add(new Vouchers(R.drawable.nike,"NIKE","Sale off 10% all products."));
        vouchers.add(new Vouchers(R.drawable.accessories,"ACCESSORIES","Sale up to 10% for all accessories items."));
    }
    private void loadData() {
        adapter = new VoucherAdapter(this,R.layout.item_myvoucher_layout,vouchers);
        lvVouchers.setAdapter(adapter);
    }

    private void addEvents() {
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txtGetMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(My_voucher.this,Voucher.class));
            }
        });
    }

    @Override
    public void btnclick(Vouchers voucher) {
        Toast.makeText(this, "Use this voucher when making payment", Toast.LENGTH_SHORT).show();
    }
}