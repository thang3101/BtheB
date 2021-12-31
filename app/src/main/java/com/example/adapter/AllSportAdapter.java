package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.AllSportsModel;
import com.example.btheb.R;

import java.util.List;

public class AllSportAdapter extends BaseAdapter {
    Context context;
    int item_layout;
    List<AllSportsModel> items;


    public AllSportAdapter(Context context, int item_layout, List<AllSportsModel> items) {
        this.context = context;
        this.item_layout = item_layout;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null)
        {
            holder=new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(item_layout, null);
            holder.imvSport = view.findViewById(R.id.imvSport);
            holder.txtSportName = view.findViewById(R.id.txtSportName);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        AllSportsModel allSportsModel = items.get(i);
        holder.imvSport.setImageResource(allSportsModel.getThumb());
        holder.txtSportName.setText(allSportsModel.getName());
        return view;
    }
    public static class ViewHolder {
        ImageView imvSport; TextView txtSportName;
    }
}
