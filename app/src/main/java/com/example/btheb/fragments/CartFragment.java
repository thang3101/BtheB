package com.example.btheb.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.CartListAdapter;
import com.example.database.Product_Database_Helper;
import com.example.model.Product;
import com.example.btheb.Checkout;
import com.example.btheb.MainActivity;
import com.example.btheb.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class CartFragment extends Fragment {
    ImageView imvClose,imvDelete, imvTickAll;
    TextView txtTotal,txtBlank;
    RecyclerView rcvListCart;
    private Button btnCheckout;
    CartListAdapter adapter;
    ArrayList<Product> products;
    Product_Database_Helper db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        imvClose =  view.findViewById(R.id.imvClose);
        rcvListCart =  view.findViewById(R.id.rcvListCart);
        btnCheckout =  view.findViewById(R.id.btnCheckout);
        imvDelete = view.findViewById(R.id.imvDelete);
        txtTotal = view.findViewById(R.id.txtTotal);
        txtBlank = view.findViewById(R.id.txtBlank);
        imvTickAll = view.findViewById(R.id.imvTickAll);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcvListCart.setLayoutManager(linearLayoutManager);

        rcvListCart.setHasFixedSize(true);
        rcvListCart.setItemAnimator(new DefaultItemAnimator());

        db = new Product_Database_Helper(getContext());
        products = db.dsCartProducts();

        DividerItemDecoration divider = new DividerItemDecoration(rcvListCart.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.custom_divider);
        divider.setDrawable(drawable);
        rcvListCart.addItemDecoration(divider);
        adapter= new CartListAdapter(getContext(),products);
        rcvListCart.setAdapter(adapter);


        imvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(CartFragment.this).commit();
                BottomNavigationView bottomNavigationView = MainActivity.bottomNavigationView;
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Checkout.class);
                startActivity(intent);
            }
        });

        imvTickAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imvTickAll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imvTickAll.setImageResource(R.drawable.tick_cart);
                    }
                });
            }
        });

        imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rcvListCart.setVisibility(View.INVISIBLE);
                txtTotal.setText("Total: $0");
                txtBlank.setVisibility(View.VISIBLE);
                imvTickAll.setImageResource(R.drawable.untick_cart);
            }
        });
        return view;
    }
}