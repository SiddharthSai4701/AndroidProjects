/*
* Adapter class for Recycler View
* */
package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    ArrayList<ModelClass> modelClassArrayList;
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(view);
    }

//    This is to set the data accoding to the item
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, webView.class);

                // We need to open the URL in a new activity which is the webview activity
                // We get the URL from modelClassArrayList
                // get(position) because we want to pass the specific URL on which the user clicks
                intent.putExtra("url", modelClassArrayList.get(position).getUrl());

                context.startActivity(intent);
            }
        });

        holder.time.setText("Published At: " + modelClassArrayList.get(position).getPublishedAt());
        holder.author.setText("Published At: " + modelClassArrayList.get(position).getAuthor());
        holder.heading.setText("Published At: " + modelClassArrayList.get(position).getTitle());
        holder.content.setText("Published At: " + modelClassArrayList.get(position).getDescription());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
//        Number of articles
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView heading, author, content, time;
        CardView cardView;
        ImageView imageView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.mainheading);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardview);

        }
    }
}
