package com.example.project_guillemaut.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.project_guillemaut.R;
import com.example.project_guillemaut.controller.ClickListener;
import com.example.project_guillemaut.model.Cat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Cat> mDataset;
    private final ClickListener listener;

    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private Cat mItem;
        Context context;
        TextView cat_age;
        TextView cat_name;
        ImageView cat_face;

        public MyViewHolder(View v, Context context) {
            super(v);
            this.context = context;
            cat_age =  v.findViewById(R.id.catage);
            cat_name =  v.findViewById(R.id.catname);
            cat_face =  v.findViewById(R.id.catface);

        }
        public void setItem(Cat item) {
            this.cat_age.setText(item.getCatAge());
            this.cat_name.setText(item.getCatName());

            Picasso.with(context).load(item.getCatPic()).into(this.cat_face);
            Log.i("Loading", item.getCatName()+" loaded with pic : "+item.getCatPic());
            mItem = item;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, ArrayList<Cat> myDataset, ClickListener listener) {

        this.context = context;
        mDataset = myDataset;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout2, parent, false);

        MyViewHolder vh = new MyViewHolder(v, context);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Cat chat = mDataset.get(position);
        holder.setItem(chat);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(chat);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
