package com.latam.covid.ui.topics;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.latam.covid.R;

public class EstadisticasFragment extends Fragment {


    WebView miVisorWeb;
    String url = "https://www.bing.com/covid/local/colombia";

    private EstadisticasViewModel mViewModel;

    public static EstadisticasFragment newInstance() {
        return new EstadisticasFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.estadisticas_fragment, container, false);
        miVisorWeb = (WebView) root.findViewById(R.id.web_estadisticas);

        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);

        miVisorWeb.loadUrl(url);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EstadisticasViewModel.class);
        // TODO: Use the ViewModel
    }

}
