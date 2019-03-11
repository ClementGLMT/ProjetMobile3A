package com.example.project_guillemaut;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_guillemaut.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Cat> mDataset;
    Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView cat_age;
        TextView cat_name;
        ImageView cat_face;
        public MyViewHolder(View v) {
            super(v);
            cat_age =  v.findViewById(R.id.catage);
            cat_name =  v.findViewById(R.id.catname);
            cat_face =  v.findViewById(R.id.catface);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, ArrayList<Cat> myDataset) {

        this.context = context;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout2, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.cat_age.setText(mDataset.get(position).getCatAge());
        holder.cat_name.setText(mDataset.get(position).getCatName());

        URL url = null;

        try {
            url = new URL(mDataset.get(position).getCatPic());
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.cat_face.setImageBitmap(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
