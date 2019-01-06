package com.example.a726020.marvelreader.presentation.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a726020.marvelreader.R;
import com.example.a726020.marvelreader.data.entity.ComicsObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ComicsListAdapter extends  RecyclerView.Adapter<ComicsListAdapter.ViewHolder> {

    private List<ComicsObjects> comicsObjectsList;
    private Fragment fragment;
    Context context;

    public ComicsListAdapter(List<ComicsObjects> comicsObjectsList, Fragment fragment) {
        this.comicsObjectsList = comicsObjectsList;
        this.fragment = fragment;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Context context = viewGroup.getContext();
       // LayoutInflater inflater = LayoutInflater.from(context);
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_comics_view, null);
        return new ViewHolder(itemLayoutView);

        // Inflate the custom layout
        //View contactView = inflater.inflate(R.layout.custom_comics_view, viewGroup, false);

        // Return a new holder instance
       // ViewHolder viewHolder = new ViewHolder(contactView);
        //return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(comicsObjectsList.get(i).getDate());

        TextView tvTitle = viewHolder.tvTitle;
        TextView tvDate = viewHolder.tvDate;
        TextView tvPageCount = viewHolder.tvPageCount;
        ImageView ivComics = viewHolder.ivComics;
        tvTitle.append(comicsObjectsList.get(i).getTitle());
        tvDate.append(date);
        tvPageCount.append(Integer.toString(comicsObjectsList.get(i).getPageCount()));
        Glide.with(this.fragment).load(comicsObjectsList.get(i).getImage()).into(ivComics);

    }

    @Override
    public int getItemCount() {
        return comicsObjectsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvDate;
        public TextView tvPageCount;
        public ImageView ivComics;



        public ViewHolder(View itemView) {

            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvPageCount = (TextView) itemView.findViewById(R.id.tvPageCount);
            ivComics = (ImageView) itemView.findViewById(R.id.ivComics);


        }
    }
}
