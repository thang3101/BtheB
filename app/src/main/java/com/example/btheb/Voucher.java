package com.example.btheb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.VoucherAdapter;
import com.example.model.Vouchers;

import java.util.ArrayList;

public class Voucher extends AppCompatActivity{

    ImageView imvback;
    ListView lvVoucher;
    VoucherAdapter adapter;
    ArrayList<Vouchers> vouchers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void linkViews() {
        lvVoucher = findViewById(R.id.lvVoucher);
        imvback = findViewById(R.id.imvBack);
    }

    private void initData() {
        vouchers = new ArrayList<>();
        vouchers.add(new Vouchers(R.drawable.nike,"NIKE","Sale off 10% all products."));
        vouchers.add(new Vouchers(R.drawable.balenciaga,"BALENCIAGA","Sale off 10% for women items"));
        vouchers.add(new Vouchers(R.drawable.accessories,"ACCESSORIES","Sale up to 10% for all accessories items."));
        vouchers.add(new Vouchers(R.drawable.converse,"CONVERSE","BUY 1 GET 1"));
    }

    private void loadData() {
        adapter = new VoucherAdapter(this,R.layout.item_voucher_layout,vouchers);
        lvVoucher.setAdapter(adapter);
    }

    private void addEvents() {
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void btngetVoucher(Button btnVoucher) {
        btnVoucher.setBackgroundColor(this.getResources().getColor(R.color.grey));
        btnVoucher.setTextColor(this.getResources().getColor(R.color.darkblue));
        Toast.makeText(Voucher.this,"Use it when making payment", Toast.LENGTH_SHORT).show(); }
}