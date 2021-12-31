package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.FAQ_Topic;
import com.example.btheb.R;

import java.util.ArrayList;

public class FAQ_TopicAdapter extends RecyclerView.Adapter<FAQ_TopicAdapter.ViewHolder> {
    Context context;
    ArrayList<FAQ_Topic> topics;

    public FAQ_TopicAdapter(Context context, ArrayList<FAQ_Topic> topics) {
        this.context = context;
        this.topics = topics;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.item_rcv_faq_layout, parent, false);
        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvTopicThumb.setImageResource(topics.get(position).getTopicThumb());
        holder.txtTopicName.setText(topics.get(position).getTopicName());

    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvTopicThumb;
        TextView txtTopicName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvTopicThumb = itemView.findViewById(R.id.imvTopicThumb);
            txtTopicName = itemView.findViewById(R.id.txtTopicName);

        }
    }
}
