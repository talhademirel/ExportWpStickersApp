package com.example.exportwpstickers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.myHolder> {

    private Context mContext;
    private ArrayList<Sticker> mData;

    public Adapter(Context mContext, ArrayList<Sticker> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.sticker,parent,false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {

        holder.stickerImage.setImageBitmap(mData.get(position).getStickerImage());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class myHolder extends RecyclerView.ViewHolder{

        ImageView stickerImage;


        public myHolder(@NonNull View itemView) {
            super(itemView);

            stickerImage = itemView.findViewById(R.id.imageView);
        }
    }
}
