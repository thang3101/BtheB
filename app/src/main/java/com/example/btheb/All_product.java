package com.example.btheb;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.Interface.MyItemClick;
import com.example.adapter.PopupSizeAdapter;
import com.example.model.Product;
import com.example.btheb.fragments.CartFragment;
import com.example.btheb.fragments.DetailFragment;
import com.example.btheb.fragments.GridProductFragment;
import com.example.btheb.fragments.ListProductFragment;
import com.example.utils.Constant;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class All_product extends AppCompatActivity implements View.OnClickListener, MyItemClick {

    ImageButton imgbtnGrid, imgbtnFilter;
    ImageView imvBack,imvCart;
    EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);

        LinkViews();
        AddEvents();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentProduct,new ListProductFragment()).commit();
    }

    private void LinkViews() {
        edtSearch = findViewById(R.id.edtSearch);
        imgbtnGrid = findViewById(R.id.imgbtnGrid);
        imgbtnFilter = findViewById(R.id.imgbtnFilter);
        imvCart = findViewById(R.id.imvCart);
        imvBack = findViewById(R.id.imvBack);
    }

    private void AddEvents() {
        imgbtnGrid.setOnClickListener(this);

        imgbtnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog b = new BottomSheetDialog(All_product.this);
                b.setContentView(R.layout.layout_popup_filter);
                b.show();
            }
        });

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        imvCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CartFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full1,fragment).commit();
            }
        });


        edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(All_product.this,Search_keyword.class));
            }
        });

    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        if(v.getId()==R.id.imgbtnGrid)
        {if(imgbtnGrid.getTag()==null || imgbtnGrid.getTag().equals("list")){
            imgbtnGrid.setImageResource(R.drawable.list);
            imgbtnGrid.setTag("grid");
            fragment = new GridProductFragment();
        }
        else {
            imgbtnGrid.setImageResource(R.drawable.grid);
            imgbtnGrid.setTag("list");
            fragment = new ListProductFragment();
        }
    }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentProduct,fragment).commit();
    }

    @Override
    public void click(Product p) {
        DetailFragment detailFragment= new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.SELECT_ITEM,p);
                detailFragment.setArguments(bundle);
                if (bundle != null)

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full1, detailFragment).
                addToBackStack(null).
                commit();
    }

    public void openSizeDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_popup_size);
        GridView gvSize = dialog.findViewById(R.id.gvPopSize);
        String[] size = { "7", "7.5", "8", "8.5", "9", "9.5"} ;
        PopupSizeAdapter adapter = new PopupSizeAdapter(this,R.layout.item_size_layout,size);
        gvSize.setAdapter(adapter);
        gvSize.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = new CartFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full1,fragment).commit();
                dialog.cancel();
            }
        });
        dialog.show();
    }
}