package com.latam.covid;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.latam.covid.R;
import com.latam.covid.models.CityContact;
import com.latam.covid.ui.adapters.ContactsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {

    public ImageButton btnContacts;
    public ImageButton btnWhatsapp;
    public static final int PICK_CONTACT = 2;
    public RecyclerView rcvContacts;
    private RecyclerView.LayoutManager layoutManager;
    private List<CityContact>listContacts = new ArrayList<>();
    private ContactsAdapter cAdapter;
    public Button btnFinish;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        btnContacts = (ImageButton)root.findViewById(R.id.btn_contaacts);
        btnWhatsapp = (ImageButton)root.findViewById(R.id.btn_whatsapp);
        rcvContacts = (RecyclerView)root.findViewById(R.id.rcv_contacts);
        rcvContacts.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rcvContacts.setLayoutManager(layoutManager);
        initContacts();
        cAdapter = new ContactsAdapter(listContacts, getActivity());
        rcvContacts.setAdapter(cAdapter);
        btnFinish = (Button)root.findViewById(R.id.button_finish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                Intent intent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                getActivity().startActivityForResult(intent, PICK_CONTACT);
            }
        });
        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.text_message_whatsapp));
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                getActivity().startActivity(sendIntent);
            }
        });

        return root;
    }

    public List<CityContact> initContacts(){

        List<CityContact> contacts = new ArrayList<>();
        contacts.add(new CityContact("Amazonas", "3153615018", ""));
        contacts.add(new  CityContact("Antioquia", "3003050295", "Tambien 774"));
        contacts.add(new  CityContact("Medellín", "123", ""));
        contacts.add(new  CityContact("Arauca", "3504120127", "Tambien línea 125"));
        contacts.add(new  CityContact("Atlántico", "(035)3236220", ""));
        contacts.add(new CityContact("Barranquilla", "3175173964", "Tambien 3793333,  – 3153002003"));
        contacts.add(new CityContact("Bogotá", "123", ""));
        contacts.add(new CityContact("Bolívar", "125", ""));
        contacts.add(new CityContact("Cartagena", "3174016183", ""));
        contacts.add(new CityContact("Boyacá", "3114834104", "Tambien 7407464"));
        contacts.add(new CityContact("Caldas", "3104267906", "Tambien (036)8800818"));
        contacts.add(new CityContact("Manizales", "123", ""));
        contacts.add(new CityContact("Caquetá", "3213945327", ""));
        contacts.add(new CityContact("Casanare", "3213945317", "Tambien (8) 6345555"));
        contacts.add(new CityContact("Cauca", "3012737787", ""));
        contacts.add(new CityContact("Cesar", "3205653159", ""));
        contacts.add(new CityContact("Valledupar", "3106332291", ""));
        contacts.add(new CityContact("Chocó", "3213945297", ""));
        contacts.add(new CityContact("Córdoba", "3205308209", "Tambien 3168751277"));
        contacts.add(new CityContact("Cundinamarca", "123", ""));
        contacts.add(new CityContact("Guainía", "3117421983", "Tambien (8)5656251 – 3117447006"));
        contacts.add(new CityContact("Guaviare", "3213946560", "Tambien 3213945350 - 3208202418 – 3213944048"));
        contacts.add(new CityContact("Huila", "8706633", "Tambien 8702277 - 8703096"));
        contacts.add(new CityContact("La Guajira", "3183400883", "Tambien 3213945330"));
        contacts.add(new CityContact("Magdalena", "3128070326", "Tambien 3213944087"));
        contacts.add(new CityContact("Santa Marta", "3012737783", ""));
        contacts.add(new CityContact("Meta", "3213945351", "Tambien 3212047605"));
        contacts.add(new CityContact("Nariño", "3177129818", ""));
        contacts.add(new CityContact("Norte de Santander", "3202714512", ""));
        contacts.add(new CityContact("Putumayo", "3123191736", "Tambien 3118784864"));
        contacts.add(new CityContact("Quindío", "3225816422", ""));
        contacts.add(new CityContact("Risaralda", "3152823059", ""));
        contacts.add(new CityContact("San Andrés", "3106511341", ""));
        contacts.add(new CityContact("Santander", "6978785", "Tambien 6978788 – 6970000 Extensión 1283 y 1287"));
        contacts.add(new CityContact("Sucre", "2822556", "Tambien  3174028049 Solo WhatsApp - 3135519643"));
        contacts.add(new CityContact("Tolima", "3228123975", ""));
        contacts.add(new CityContact("Valle del Cauca", "6206819", ""));
        contacts.add(new CityContact("Cali", "4865555", " Opción 7"));
        contacts.add(new CityContact("Buenaventura", "3172870273", ""));
        contacts.add(new CityContact("Vaupés", "3213945341",  "CRUE 301 458 76 39"));
        contacts.add(new CityContact("Vichada", "3222476344", ""));
        listContacts.addAll(contacts);
        return contacts;
    }


}

