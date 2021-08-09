package com.thisisshivamgupta.taknews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.thisisshivamgupta.taknews.Models.NewsHeadlines;

import java.util.List;

public class CustomAdaptor extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<NewsHeadlines> headlines;
    private SelectListener listener;

    public CustomAdaptor(Context context, List<NewsHeadlines> headlines,SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener= listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());

        if(headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnNewsCliked(headlines.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
