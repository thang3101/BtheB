package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.CustomerService;
import com.example.btheb.R;

import java.util.List;

public class CustomerService_Adapter extends BaseAdapter {

    Context context;
    int item_listview;
    List<CustomerService> service_items;

    public CustomerService_Adapter(Context context, int item_listview, List<CustomerService> service_items) {
        this.context = context;
        this.item_listview = item_listview;
        this.service_items = service_items;

    }
    @Override
    public int getCount() {
        return service_items.size();
    }

    @Override
    public Object getItem(int position) {
        return service_items.get(position);
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
            view = layoutInflater.inflate(R.layout.item_customer_service_layout,null);
            holder.txtCustomerServiceName = view.findViewById(R.id.txtCustomerServiceName);
            holder.imvCSIcon = view.findViewById(R.id.imvCSIcon);

            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        CustomerService i = service_items.get(position);
        holder.txtCustomerServiceName.setText(i.getCustomerService_Name());
        holder.imvCSIcon.setImageResource(i.getCustomerService_Icon());
        return view;
    }

    public static class ViewHolder {
        TextView txtCustomerServiceName;
        ImageView imvCSIcon;
    }
}



