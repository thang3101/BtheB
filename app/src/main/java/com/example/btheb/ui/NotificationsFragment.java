package com.example.btheb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.adapter.MessageAdapter;
import com.example.adapter.OrderAdapter;
import com.example.model.Messages;
import com.example.model.Order;
import com.example.btheb.R;
import com.example.btheb.Track_My_Order;
import com.example.btheb.Track_order_Details;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

        ListView lvNotification, lvOrder;
        ArrayList<Messages> notiArrayList;
        ArrayList<Order> orderArrayList;
        MessageAdapter notiAdapter;
        OrderAdapter orderAdapter;
        TextView txtOrders;

public View onCreateView(@NonNull LayoutInflater inflater,
         ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);


        lvNotification = view.findViewById(R.id.lvNotification);
        lvOrder = view.findViewById(R.id.lvOrder);
        txtOrders = view.findViewById(R.id.txtOrderUpdate);

        initData();
        loadData();
        AddEvents();
        return view ;
        }

    private void initData() {
        //Notification
        notiArrayList = new ArrayList<>();
        notiArrayList.add( new Messages(R.drawable.image_mess1,"PEGASUS 38 FLYEASE LIGHTING"));
        notiArrayList.add( new Messages(R.drawable.image_mess2,"SHOP FOR RUNNING SHOES LIKE A PRO"));
        notiArrayList.add( new Messages(R.drawable.image_mess3,"NEW FAIRIES"));

        //Order
        orderArrayList = new ArrayList<>();
        orderArrayList.add(new Order(R.drawable.product_1,"Parcel Delivered","Parcel 12345 for your order has been deliverred"));
        orderArrayList.add(new Order(R.drawable.product_1,"Shipped Out","Your order has been shipped out by GHN. Click here to see order details"));
        orderArrayList.add(new Order(R.drawable.product_1,"Payment Confirm","We ‘re notified the seller. Kindly wait for your shipment"));
        }
    private void loadData() {
        //Notification
        notiAdapter = new MessageAdapter(getContext(), R.layout.item_noti_layout,notiArrayList);
        lvNotification.setAdapter(notiAdapter);

        //Order
        orderAdapter = new OrderAdapter(getContext(),R.layout.item_order_layout,orderArrayList);
        lvOrder.setAdapter(orderAdapter);
    }

    private void AddEvents() {
        txtOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Track_My_Order.class));
            }
        });

        lvOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(),Track_order_Details.class));
            }
        });
    }
}
