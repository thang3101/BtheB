package com.example.btheb.fragments;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.Interface.MyItemClick;
import com.example.adapter.All_Product_Adapter;
import com.example.database.Product_Database_Helper;
import com.example.model.Product;
import com.example.btheb.R;

import java.util.ArrayList;

public class ListProductFragment extends Fragment {
    ListView lvProduct;
    All_Product_Adapter adapter;
    ArrayList<Product> items;
    MyItemClick itemClick;
    TextView txtName,txtPrice,txtType;
    ImageView imvThumb;
    Product_Database_Helper db;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_product, container, false);
        lvProduct = view.findViewById(R.id.lvProducts);
        txtName = view.findViewById(R.id.txtName);
        txtPrice = view.findViewById(R.id.txtPrice);
        txtType = view.findViewById(R.id.txtType);
        imvThumb = view.findViewById(R.id.imvThumb);

        db = new Product_Database_Helper(getContext());

        items = db.dsAllProducts();
        adapter= new All_Product_Adapter(getContext(),R.layout.item_product_listview_layout,items);
        lvProduct.setAdapter(adapter);
         return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    itemClick = (MyItemClick) getActivity();
                    if(itemClick!=null)
                    { itemClick.click(items.get(position)); }
                }
                else
                {
                    txtName.setText(items.get(position).getName());
                    txtPrice.setText(String.valueOf(items.get(position).getPrice()));
                    txtType.setText(items.get(position).getType());
                    byte[] photo = items.get(position).getThumb();
                    Bitmap bitmap = BitmapFactory.decodeByteArray(photo,0,photo.length);
                    imvThumb.setImageBitmap(bitmap);
                }
            }
        });
    }
}