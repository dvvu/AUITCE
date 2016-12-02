package com.project.uit.auitce.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.project.uit.auitce.DeviceInfo;
import com.project.uit.auitce.R;
import com.project.uit.auitce.callBack.OnClickListenerRecycler;
import com.project.uit.auitce.callBack.OnClickListenerRecycler3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leehoa on 11/25/16.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{
    List<Bitmap> images;
    int type;
    OnClickListenerRecycler onClickListenerRecycler;
    OnClickListenerRecycler3 onClickListenerRecycler3;
    public  HomeAdapter(List<Bitmap> images, int type) {
        this.images = images;
        this.type = type;
    }
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_cell, null);
        return new ViewHolder(view);
    }

    public void setOnClickListenerRecycler(OnClickListenerRecycler onClickListenerRecycler) {
        this.onClickListenerRecycler = onClickListenerRecycler;
    }

    public void setOnClickListenerRecycle3r(OnClickListenerRecycler3 onClickListenerRecycler3) {
        this.onClickListenerRecycler3 = onClickListenerRecycler3;
    }


    @Override
    public void onBindViewHolder(final HomeAdapter.ViewHolder holder, final int position) {
        holder.setImage(images.get(position));
        if (type == 1) {
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListenerRecycler.onClicked(images.get(position));
                }
            });
        } else if (type == 2) {
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        } else if (type == 3) {
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListenerRecycler3.onClicked(position);
                }
            });
        }

    }

    public void updateData(ArrayList<Bitmap> viewModels) {
        images.clear();
        images.addAll(viewModels);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.imageId);
            image.setLayoutParams(new LinearLayout.LayoutParams(DeviceInfo.getScreenWidth()/2,DeviceInfo.getScreenWidth()/2));
        }

        public void setImage(Bitmap images) {
            image.setImageBitmap(images);
        }
    }
}
