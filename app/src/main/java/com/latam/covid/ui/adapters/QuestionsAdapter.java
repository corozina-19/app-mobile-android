package com.latam.covid.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.latam.covid.R;
import com.latam.covid.models.EQuestions;
import com.latam.covid.models.MainDetail;

import java.util.ArrayList;
import java.util.List;

public class QuestionsAdapter  extends RecyclerView.Adapter<QuestionsViewHolder> {

    private Context mContext;
    private List<EQuestions> mList;

    public QuestionsAdapter(List<EQuestions> list, Context context){
        super();
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diagnostic_list, parent, false);
        QuestionsViewHolder viewHolder = new QuestionsViewHolder(v);

        return viewHolder;
    }


    public void setQuestions(ArrayList<EQuestions> questions) {
        this.mList = new ArrayList<>();
        this.mList = questions;
        notifyDataSetChanged();
    }

    public List<EQuestions> getAll() {
        return mList;
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionsViewHolder holder, int position) {

        EQuestions eObject = mList.get(position);
        holder.bind(eObject, mContext);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public ArrayList<EQuestions> getSelected() {
        ArrayList<EQuestions> selected = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).isChecked()) {
                selected.add(mList.get(i));
            }
        }
        return selected;
    }
}
