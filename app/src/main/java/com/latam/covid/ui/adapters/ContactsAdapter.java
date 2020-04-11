package com.latam.covid.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.latam.covid.R;
import com.latam.covid.models.CityContact;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsViewHolder> {

    private Context mContext;
    private List<CityContact> mList;

    public ContactsAdapter(List<CityContact> list, Context context){
        super();
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_list, parent, false);
        ContactsViewHolder viewHolder = new ContactsViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        CityContact eObject = mList.get(position);
        holder.bind(eObject, mContext);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
