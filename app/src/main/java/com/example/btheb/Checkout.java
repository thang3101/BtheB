package com.example.btheb;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Interface.MyBtnVoucherClick;
import com.example.adapter.OrderDetailAdapter;
import com.example.adapter.PaymentMethodAdapter;
import com.example.adapter.VoucherAdapter;
import com.example.model.Order_Detail;
import com.example.model.PaymentMethod;
import com.example.model.Vouchers;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class Checkout extends AppCompatActivity implements MyBtnVoucherClick {

    ListView lvItemCheckouts;
    ArrayList<Order_Detail> order_detailList;
    OrderDetailAdapter orderAdapter;

    RecyclerView rcvPaymentMethod;
    ArrayList<PaymentMethod> methods;
    PaymentMethodAdapter methodAdapter;
    BottomSheetDialog dialog;
    ImageView imvBack, imvDelivery;
    Button btnOrder;
    TextView txtRedeem,txtSubVoucher,txtVoucherValue,txtQTyVoucher,txtEdit, txtDelivery, txtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        linkViews();
        initData();
        loadData();
        addEvents();
    }


    private void linkViews() {
        txtEdit = findViewById(R.id.txtEditDelivery);
        lvItemCheckouts = findViewById(R.id.lvItemCheckouts);
        rcvPaymentMethod = findViewById(R.id.rcvPaymentMethod);
        imvBack = findViewById(R.id.imvback_checkout);
        txtRedeem = findViewById(R.id.txtRedeem);
        txtSubVoucher = findViewById(R.id.txtSubvoucher);
        txtVoucherValue = findViewById(R.id.txtVouchervalue);
        txtQTyVoucher = findViewById(R.id.txtqtyvoucher);
        btnOrder = findViewById(R.id.btnOrderPlace);
        txtPrice = findViewById(R.id.txtPriceDelivery);
        txtDelivery = findViewById(R.id.txtDelivery);
        imvDelivery = findViewById(R.id.imvDelivery);
    }

    private void initData() {

        //nạp dữ liệu vào danh sách item
        order_detailList = new ArrayList<>();
        order_detailList.add(new Order_Detail(R.drawable.sneaker2,"Ultraboost 29 Shoes","Fashion shoes",170.0,1,"To recieve"));
        order_detailList.add(new Order_Detail(R.drawable.sneaker1,"Ultraboost 29 Shoes","Fashion shoes",140.0,2,"Processing"));
        //nạp dữ liệu vào danh sách phương thức thanh toán
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rcvPaymentMethod.setLayoutManager(manager);
        rcvPaymentMethod.setHasFixedSize(true);
        rcvPaymentMethod.setItemAnimator(new DefaultItemAnimator());
        methods = new ArrayList<>();
        methods.add(new PaymentMethod("Cash On Delivery","Pay when you receive",R.drawable.selected,R.drawable.cod));
        methods.add(new PaymentMethod("Internet Banking","Payment processed at Napas",R.drawable.nonselected,R.drawable.ebanking));
        methods.add(new PaymentMethod("E-wallet","Pay with E-Wallet App",R.drawable.nonselected,R.drawable.ewallet));
        DividerItemDecoration divider = new DividerItemDecoration(rcvPaymentMethod.getContext(),DividerItemDecoration.HORIZONTAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        divider.setDrawable(drawable);
        rcvPaymentMethod.addItemDecoration(divider);
    }

    private void loadData() {
       //nạp dữ liệu vào danh sách item
        orderAdapter = new OrderDetailAdapter(Checkout.this, R.layout.item_checkout_layout,order_detailList);
        lvItemCheckouts.setAdapter(orderAdapter);
        //nạp dữ liệu vào danh sách phương thức thanh toán
        methodAdapter = new PaymentMethodAdapter(getApplicationContext(),methods);
        rcvPaymentMethod.setAdapter(methodAdapter);
    }

    private void addEvents() {
        txtRedeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new BottomSheetDialog(Checkout.this);
                dialog.setContentView(R.layout.layout_popup_myvoucher);
                ListView lvVoucher = dialog.findViewById(R.id.lvMyVoucherPopUp);
                VoucherAdapter adapter;
                ArrayList<Vouchers> vouchers;
                vouchers = new ArrayList<>();
                vouchers.add(new Vouchers(R.drawable.converse,"CONVERSE","BUY 1 GET 1"));
                vouchers.add(new Vouchers(R.drawable.balenciaga,"BALENCIAGA","Sale off 10%"));
                vouchers.add(new Vouchers(R.drawable.nike,"NIKE","Sale off 10% "));
                adapter = new VoucherAdapter(Checkout.this,R.layout.item_myvoucher_layout,vouchers);
                lvVoucher.setAdapter(adapter);
                dialog.show();
            }
        });

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Checkout.this,Track_order_Details.class));
            }
        });

        txtEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialogDelivery = new Dialog(Checkout.this);
                dialogDelivery.setContentView(R.layout.layout_popup_delivery);
                dialogDelivery.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayout llStandard, llFast, ll24h;
                llStandard = dialogDelivery.findViewById(R.id.llStandard);
                llFast = dialogDelivery.findViewById(R.id.llFast);
                ll24h = dialogDelivery.findViewById(R.id.ll24h);
                switchDeliveryMethod(ll24h, llStandard, llFast , dialogDelivery);
                dialogDelivery.show();
            }
        });
    }

    private void switchDeliveryMethod(LinearLayout ll24h, LinearLayout llStandard, LinearLayout llFast, Dialog dialogDelivery) {
        llStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDelivery.setText("Standard Delivery");
                txtPrice.setText("3$");
                imvDelivery.setImageResource(R.drawable.standard_deli);
                dialogDelivery.cancel();
            }
        });

        llFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDelivery.setText("Fast Delivery");
                txtPrice.setText("5$");
                imvDelivery.setImageResource(R.drawable.fast_deli);
                dialogDelivery.cancel();
            }
        });

        ll24h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDelivery.setText("24h Delivery");
                txtPrice.setText("10$");
                imvDelivery.setImageResource(R.drawable.deli_24h);
                dialogDelivery.cancel();
            }
        });
    }

    @Override
    public void btnclick(Vouchers voucher) {
        txtRedeem.setText(voucher.getTxtTittle());
        if (txtRedeem.getText() != "Redeem"){
            txtQTyVoucher.setText("1");
            txtSubVoucher.setText("Redeem (1) Voucher");
            txtVoucherValue.setText("-$5.00");
        }
        dialog.dismiss();
    }
}