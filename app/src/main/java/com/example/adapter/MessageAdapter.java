package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Interface.MyMessClick;
import com.example.model.Messages;
import com.example.btheb.R;

import java.util.List;

public class MessageAdapter extends BaseAdapter {

    Context context;
    int item_layout;
    List<Messages> items;
    MyMessClick messClick;


    public MessageAdapter(Context context, int item_layout, List<Messages> items) {
        this.context = context;
        this.item_layout = item_layout;
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
            view = layoutInflater.inflate(item_layout,null);
            holder.imvMessageThumb = view.findViewById(R.id.imvMessThumb);
            holder.txtMessageName = view.findViewById(R.id.txtMessageName);
            holder.btnExplore = view.findViewById(R.id.btnExplore);

            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        Messages m = items.get(position);
        holder.imvMessageThumb.setImageResource(m.getMessage_Thumb());
        holder.txtMessageName.setText(m.getMessage_Name());
        holder.btnExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof MyMessClick) {
                    ((MyMessClick) context).messclick(m);
                    }
            }
        });
        return view;
    }

    public static class ViewHolder {
        ImageView imvMessageThumb;
        TextView txtMessageName;
        Button btnExplore;
    }
}

