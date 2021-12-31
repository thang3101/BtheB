package com.example.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.btheb.R;

public class PopupSizeAdapter extends BaseAdapter {
    Context context;
    int item_layout;
    String[] items;

    public PopupSizeAdapter(Context context, int item_layout, String[] items) {
        this.context = context;
        this.item_layout = item_layout;
        this.items = items;
    }

    int selected = -1;
    public void selectedPosition(int i)
    {
        selected = i;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
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
            holder.txtSize = view.findViewById(R.id.txtSize);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        int[] state = new int[] {android.R.attr.state_selected};
        int[] state2 = new int[] {-android.R.attr.state_selected};

        holder.txtSize.setText(items[i]);

        if(i == selected)
        {
            holder.txtSize.getBackground().setState(state);
            holder.txtSize.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else {holder.txtSize.getBackground().setState(state2);
        holder.txtSize.setTextColor(Color.parseColor("#031824"));}

        return view;
    }

    public static class ViewHolder{
        TextView txtSize;
    }
}
