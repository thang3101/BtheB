package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.More;
import com.example.btheb.R;

import java.util.ArrayList;

public class MoreAdapter extends BaseAdapter {
    private Context context;
    int item_layout;
    ArrayList<More>morelist;

    public MoreAdapter(Context context, int item_layout, ArrayList<More> morelist) {
        this.context =context;
        this.item_layout = item_layout;
        this.morelist = morelist;

    }

    @Override
    public int getCount() {
        return morelist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
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
            holder.imvicon_moreitem = view.findViewById(R.id.imvicon_moreitem);
            holder.txtmoreitem = view.findViewById(R.id.txtmore_item);
            view.setTag(holder);
        } else {holder =(ViewHolder) view.getTag();}
        More more = morelist.get(i);
        holder.imvicon_moreitem.setImageResource(more.getImvicon_moreitem());
        holder.txtmoreitem.setText(more.getTxtmoreitem().toString());
        return view;
    }
    public class ViewHolder{
        ImageView imvicon_moreitem;
        TextView txtmoreitem;
    }
}
