package com.example.btheb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.adapter.MoreAdapter;
import com.example.model.More;
import com.example.btheb.CustomerServiceActivity;
import com.example.btheb.Delivery;
import com.example.btheb.Language;
import com.example.btheb.Message;
import com.example.btheb.MyAccount;
import com.example.btheb.My_voucher;
import com.example.btheb.R;
import com.example.btheb.Track_My_Order;

import java.util.ArrayList;

public class MoreFragment extends Fragment {

    ListView lvMore;
    ArrayList<More> morelist;
    MoreAdapter moreAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        lvMore = view.findViewById(R.id.lvMore);
        morelist = new ArrayList<>();
        morelist.add(new More(R.drawable.account_icon,"My Account"));
        morelist.add(new More(R.drawable.mymess_icon,"My Message"));
        morelist.add(new More(R.drawable.delivery_icon,"Delivery"));
        morelist.add(new More(R.drawable.track_icon,"Track My Order"));
        morelist.add(new More(R.drawable.customerservice_icon,"Customer Service"));
        morelist.add(new More(R.drawable.myvoucher_icon,"My Voucher"));
        morelist.add(new More(R.drawable.language_icon,"Language"));

        moreAdapter = new MoreAdapter(getContext(),R.layout.item_more_layout,morelist);
        lvMore.setAdapter(moreAdapter);

        lvMore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                More m = morelist.get(position);
                switch (m.getTxtmoreitem())
                {
                    case "My Account" :  startActivity(new Intent(getContext(), MyAccount.class)); break;
                    case "My Message" :  startActivity(new Intent(getContext(), Message.class)); break;
                    case "Delivery" : startActivity(new Intent(getContext(), Delivery.class)); break;
                    case "Language" :  startActivity(new Intent(getContext(), Language.class)); break;
                    case "My Voucher" :  startActivity(new Intent(getContext(), My_voucher.class)); break;
                    case "Customer Service" : startActivity(new Intent(getContext(), CustomerServiceActivity.class)); break;
                    case "Track My Order" : startActivity(new Intent(getContext(), Track_My_Order.class)); break;
                }
            }
        });
        return view ;
    }
}
