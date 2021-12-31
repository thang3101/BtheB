package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btheb.R;


public class RecentAndTrendingAdapter extends RecyclerView.Adapter<RecentAndTrendingAdapter.ViewHolder> {
    Context context;
    String[] products;


    public RecentAndTrendingAdapter(Context context, String[] products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.item_trending_recent_layout,parent,false);
        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.btnRecent.setText(products[position]);
    }

    @Override
    public int getItemCount() {
        return products.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        Button btnRecent;
        public ViewHolder(@NonNull View itemView){
            super (itemView);
            btnRecent = itemView.findViewById(R.id.btnTrendAndRecent);
        }
    }
}
