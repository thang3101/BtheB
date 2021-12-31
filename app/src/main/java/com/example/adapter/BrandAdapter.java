package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.btheb.R;

public class BrandAdapter extends BaseAdapter {
    Context context;
    int item_layout;
    int[] brandList;


    public BrandAdapter(Context context, int item_layout, int[] brandList) {
        this.context = context;
        this.item_layout = item_layout;
        this.brandList = brandList;
    }

    @Override
    public int getCount() {
        return brandList.length;
    }

    @Override
    public Object getItem(int i) {
        return brandList[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(item_layout,null);
            holder.imvbrand = view.findViewById(R.id.imvbrand_item);
            view.setTag(holder);
        } else {holder =(ViewHolder) view.getTag();}
        holder.imvbrand.setImageResource(brandList[i]);
        return view;
    }

    public class ViewHolder{
        ImageView imvbrand;
    }
}
