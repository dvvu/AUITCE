package com.project.uit.auitce.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.uit.auitce.R;

import java.util.List;

/**
 * Created by leehoa on 11/25/16.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{
    List<String> lsText;
    public  HomeAdapter(List<String> lsText) {
        this.lsText = lsText;
    }
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_cell, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {
        holder.setText(lsText.get(position));
    }

    @Override
    public int getItemCount() {
        return lsText.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tet);
        }

        public void setText(String text) {
            textView.setText(text);
        }
    }
}
