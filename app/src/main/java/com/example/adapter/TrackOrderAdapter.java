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

import java.util.List;

public class TrackOrderAdapter extends BaseAdapter {

    Context context;
    int item_listview;
    List<Order_Detail> items;


    public TrackOrderAdapter(Context context, int item_listview, List<Order_Detail> items) {
        this.context = context;
        this.item_listview = item_listview;
        this.items = items;
    }



    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null)
        {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(item_listview,null);
            holder.imvThumb = view.findViewById(R.id.imvThumb);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtStatus = view.findViewById(R.id.txtStatus);
            holder.txtQuantity = view.findViewById(R.id.txtQuantity);
            holder.txtPrice = view.findViewById(R.id.txtPrice);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        Order_Detail i = items.get(position);
        holder.imvThumb.setImageResource(i.getThumb());
        holder.txtName.setText(i.getName());
        String price = "$" + String.valueOf(i.getPrice());
        holder.txtPrice.setText(price);
        String qty = "x" + String.valueOf(i.getQuantity());
        holder.txtQuantity.setText(qty);
        holder.txtStatus.setText(i.getStatus());
        return view;
    }


    public static class ViewHolder {
        ImageView imvThumb;
        TextView txtName,txtPrice,txtQuantity,txtStatus;
    }
}


