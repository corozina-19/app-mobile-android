package com.latam.covid.ui.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.latam.covid.R;

public class MainViewHolder extends RecyclerView.ViewHolder {

    public TextView txtName;
    public TextView txtDescription;
    public ImageView imgBigIcon;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        txtName = (TextView) itemView.findViewById(R.id.txt_name);
        txtDescription = (TextView) itemView.findViewById(R.id.txt_desc);
        imgBigIcon = (ImageView)itemView.findViewById(R.id.img_big_icon);

    }
}
