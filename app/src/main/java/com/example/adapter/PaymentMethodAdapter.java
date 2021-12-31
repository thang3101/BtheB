package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.PaymentMethod;
import com.example.btheb.R;

import java.util.ArrayList;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder> {
    Context context;
    ArrayList<PaymentMethod> methods;

    public PaymentMethodAdapter(Context context, ArrayList<PaymentMethod> methods) {
        this.context = context;
        this.methods = methods;
    }


    int selected ;
    public void selectedPosition(int i)
    {
        selected = i;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.item_paymentmethod_layout,parent,false);
        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtTitle.setText(""+ methods.get(position).getTitle());
        holder.txtDes.setText(""+ methods.get(position).getDescrip());
        holder.imvThumb.setImageResource(methods.get(position).getThumb());
        holder.imvStatus.setImageResource(methods.get(position).getStatus());

        int[] state = new int[] {android.R.attr.state_selected};
        int[] state2 = new int[] {-android.R.attr.state_selected};

        if(position == selected)
        {
            holder.imvStatus.getDrawable().setState(state);
        }
        else {holder.imvStatus.getDrawable().setState(state2);
        }
    }

    @Override
    public int getItemCount() {

        return methods.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtDes;
        ImageView imvThumb, imvStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle_PMethod);
            txtDes = itemView.findViewById(R.id.txtDescripPMethod);
            imvStatus = itemView.findViewById(R.id.imvStatus);
            imvThumb = itemView.findViewById(R.id.imvThumb_PMethod);

        }
    }
}