package com.example.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Product;
import com.example.btheb.All_product;
import com.example.btheb.R;

import java.util.List;


public class All_Product_Adapter extends BaseAdapter {
    All_product context;
    int layout;
    List<Product> products;


    public All_Product_Adapter(Context context, int layout, List<Product> products) {
        this.context = (All_product) context;
        this.layout = layout;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if ( convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(layout, null);
            viewHolder.imvThumb=(ImageView) convertView.findViewById(R.id.imvThumb);
            viewHolder.txtName=(TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtPrice=(TextView) convertView.findViewById(R.id.txtPrice);
            viewHolder.btnQuickBuy = convertView.findViewById(R.id.btnQuickBuy);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Product p= products.get(i);
        viewHolder.txtName.setText(p.getName());
        viewHolder.txtPrice.setText(String.valueOf(p.getPrice()));

        byte[] photo = p.getThumb();
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo,0,photo.length);
        viewHolder.imvThumb.setImageBitmap(bitmap);

        viewHolder.btnQuickBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.openSizeDialog();
            }
        });
        return convertView;
    }

    private class ViewHolder{
        TextView txtName,txtPrice;
        ImageView imvThumb;
        Button btnQuickBuy;
    }
}

