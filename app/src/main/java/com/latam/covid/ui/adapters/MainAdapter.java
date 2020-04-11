package com.latam.covid.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.latam.covid.DiagActivity;
import com.latam.covid.R;
import com.latam.covid.TopicsActivity;
import com.latam.covid.models.MainDetail;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<MainDetail> mList;
    private Context mContext;

    public MainAdapter(List<MainDetail> list, Context context){
        super();
        mList = list;
        mContext = context;
    }

    public List<MainDetail> getmList() {
        return mList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_list, parent, false);
        MainViewHolder viewHolder = new MainViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {

        MainDetail itemAdapter = mList.get(position);

        holder.txtName.setText(itemAdapter.getName());
       // holder.txtDescription.setText(itemAdapter.getDetail());
        holder.imgBigIcon.setImageResource(itemAdapter.getImageBigIcon());
        holder.cardMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == 0) {

                    Intent i = new Intent (mContext, DiagActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(i);
                }
                else{
                    Intent i = new Intent (mContext, TopicsActivity.class);
                    i. putExtra("TOPICS", position);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(i);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

/*    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MainDetail itemAdapter = mList.get(position);

    }*/






