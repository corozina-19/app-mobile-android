package com.latam.covid.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.latam.covid.R;
import com.latam.covid.models.EQuestions;

public class QuestionsViewHolder  extends RecyclerView.ViewHolder{

     public TextView titleQuestions;
     public ImageButton btnInfo;
     public LinearLayout lnyQuestions;
     public Context cntx;


    public QuestionsViewHolder(@NonNull View itemView) {
        super(itemView);
        titleQuestions  = (TextView) itemView.findViewById(R.id.txt_title);
        btnInfo = (ImageButton)itemView.findViewById(R.id.img_info);
        lnyQuestions = (LinearLayout)itemView.findViewById(R.id.lyn_items_questions);
    }

     public void bind (final EQuestions objEQuestions, Context context){


         titleQuestions.setText(objEQuestions.getName());
         cntx = context;

         //imageView.setVisibility(employee.isChecked() ? View.VISIBLE : View.GONE);

         if (objEQuestions.getDetail()){
             btnInfo.setVisibility(View.VISIBLE);
             //btnInfo.setTooltipText( "Hola");
         }else{
             btnInfo.setVisibility(View.GONE);
         }

         lnyQuestions.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (!objEQuestions.isChecked()){
                     objEQuestions.setChecked(true);
                     titleQuestions.setTextColor(context.getResources().getColor(R.color.white));
                     lnyQuestions.setBackgroundResource(R.drawable.style_item_checked);

                 }else{
                     titleQuestions.setTextColor(context.getResources().getColor(R.color.gray_text));
                     objEQuestions.setChecked(false);
                     lnyQuestions.setBackgroundResource(R.drawable.style_item_select);

                 }

         /*        if (cntx instanceof OnItemClickListenerQuestions) {
                     ((OnItemClickListenerQuestions) cntx).SetSelected(objEQuestions);
                 }*/

             }

         });

   /*  btnInfo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 btnInfo.setTooltipText("hola");
             }
         });*/
     }
}
