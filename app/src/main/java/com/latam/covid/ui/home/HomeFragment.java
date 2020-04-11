package com.latam.covid.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.latam.covid.R;
import com.latam.covid.models.MainDetail;
import com.latam.covid.ui.adapters.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView rcvMain;
    private RecyclerView.Adapter mainAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<MainDetail> listMain = new ArrayList<MainDetail>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        rcvMain =  (RecyclerView) root.findViewById(R.id.rcv_main_items);
        rcvMain.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rcvMain.setLayoutManager(layoutManager);
        loadMainList();
        mainAdapter = new MainAdapter(listMain, getActivity().getApplicationContext());
        rcvMain.setAdapter(mainAdapter);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
             //   textView.setText(s);
            }
        });

        return root;
    }

    public void loadMainList(){

        listMain.clear();
        listMain.add(0, new MainDetail(getString(R.string.title_diagnostico), getString(R.string.desc_diagnostico), R.drawable.image_diagnostico_menu));
        listMain.add(1, new MainDetail(getString(R.string.title_sintomas), getString(R.string.desc_diagnostico), R.drawable.image_sistomas_menu));
        listMain.add(2, new MainDetail(getString(R.string.title_contacto), getString(R.string.desc_diagnostico), R.drawable.image_contagio_menu));
        listMain.add(3, new MainDetail(getString(R.string.title_prevencion), getString(R.string.desc_diagnostico), R.drawable.image_prevencion_menu));
        listMain.add(4, new MainDetail(getString(R.string.title_cura), getString(R.string.desc_diagnostico), R.drawable.image_estadistica_menu));
        listMain.add(5, new MainDetail(getString(R.string.title_fakenews), getString(R.string.desc_diagnostico), R.drawable.image_fake_news_menu));

    }
}
