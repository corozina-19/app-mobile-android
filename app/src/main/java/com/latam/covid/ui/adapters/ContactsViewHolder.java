package com.latam.covid.ui.adapters;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.latam.covid.DiagActivity;
import com.latam.covid.R;
import com.latam.covid.models.CityContact;

public class ContactsViewHolder extends RecyclerView.ViewHolder {

  private  TextView txtCity;
  private TextView txtDescription;
  private TextView txtNumber;
  private LinearLayout lnyContacts;

    public ContactsViewHolder(@NonNull View itemView) {
        super(itemView);

        txtCity = (TextView)itemView.findViewById(R.id.txt_city);
        txtDescription = (TextView)itemView.findViewById(R.id.txt_description);
        txtNumber = (TextView)itemView.findViewById(R.id.txt_number);
        lnyContacts = (LinearLayout)itemView.findViewById(R.id.lyn_items_contacts);
    }

    public void bind (final CityContact cityContact, Context context){

        txtCity.setText(cityContact.getCity());
        txtDescription.setText(cityContact.getDescription());
        txtNumber.setText(cityContact.getPhoneNumber());

        lnyContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent my_callIntent = new Intent(Intent.ACTION_DIAL);
                    my_callIntent.setData(Uri.parse("tel:" + cityContact.getPhoneNumber()));
                    context.startActivity(my_callIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(context, "Error in your phone call"+e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
