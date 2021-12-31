package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Order_Detail;
import com.example.btheb.R;

import java.util.ArrayList;

public class OrderDetailAdapter extends BaseAdapter {

    private Context context;
    int layout;
    ArrayList<Order_Detail> orders;

    public OrderDetailAdapter(Context context, int layout, ArrayList<Order_Detail> orders) {
        this.context = context;
        this.layout = layout;
        this.orders = orders;

    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout,null);
            holder.imvThumb = view.findViewById(R.id.imvThumb_checkout);
            holder.txtName = view.findViewById(R.id.txtName_checkout);
            holder.txtType = view.findViewById(R.id.txtType_checkout);
            holder.txtPrice = view.findViewById(R.id.txtPrice_checkout);
            holder.txtQuantity = view.findViewById(R.id.txtquantity);

            view.setTag(holder);
        } else {holder = (ViewHolder) view.getTag();}
        Order_Detail order = orders.get(i);
        holder.imvThumb.setImageResource(order.getThumb());
        holder.txtName.setText(order.getName());
        holder.txtType.setText(order.getType());
        holder.txtPrice.setText("$ " + String.valueOf(order.getPrice()));
        holder.txtQuantity.setText(String.valueOf(order.getQuantity()));
        return view;
    }
    public class ViewHolder{
        ImageView imvThumb;
        TextView txtName,txtType,txtPrice,txtQuantity;
    }
}
