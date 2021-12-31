package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Order;
import com.example.btheb.R;

import java.util.ArrayList;

public class OrderAdapter extends BaseAdapter {
    private Context context;
    int item_layout;
    ArrayList<Order> orderList;

    public OrderAdapter(Context context, int item_layout, ArrayList<Order> orderList) {
        this.context = context;
        this.item_layout = item_layout;
        this.orderList = orderList;

    }

    @Override
    public int getCount() {
        return orderList.size();
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
            view = layoutInflater.inflate(item_layout,null);
            holder.imvThumb_order = view.findViewById(R.id.imvThumb_Order);
            holder.txtStatus = view.findViewById(R.id.txtStatus_order);
            holder.txtDetail = view.findViewById(R.id.txtDetail_order);
            view.setTag(holder);
        } else {holder = (ViewHolder) view.getTag();}
        Order order = orderList.get(i);
        holder.imvThumb_order.setImageResource(order.getImvThumb_Order());
        holder.txtStatus.setText(order.getTxtStatus_order().toString());
        holder.txtDetail.setText(order.getTxtDetail_order().toString());

        return view;
    }
    public class ViewHolder{
        ImageView imvThumb_order;
        TextView txtStatus,txtDetail;

    }
}
