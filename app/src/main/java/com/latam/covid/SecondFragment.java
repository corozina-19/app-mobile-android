package com.latam.covid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.latam.covid.Enum.Covid;

import Utils.GlobalVars;

public class SecondFragment extends Fragment {

   private TextView txtTitle;
   private TextView txtSubTitle;
   private TextView txtDetail;
   private Button btnNext;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_second, container, false);
        txtTitle = (TextView)root.findViewById(R.id.txt_title_result);
        txtSubTitle = (TextView)root.findViewById(R.id.text_subtitle);
        txtDetail = (TextView)root.findViewById(R.id.text_detail);
        btnNext = (Button)root.findViewById(R.id.button_next);
        validateCovid();
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Toast.makeText(getActivity(), "Prueba", Toast.LENGTH_LONG).show();

                if (!GlobalVars.DiAGNOSTIC.equals(Covid.COVID)) {

                    getActivity().finish();
                }else{

                    NavHostFragment.findNavController(SecondFragment.this)
                            .navigate(R.id.action_SecondFragment_to_ContactFragment);

                }
            }
        });
    }

    public void validateCovid()
    {
        if (GlobalVars.DiAGNOSTIC == Covid.COVID) {
            btnNext.setText(getResources().getText(R.string.text_button_next));
            txtTitle.setText(getResources().getString(R.string.title_description_result));
            txtSubTitle.setText(getResources().getString(R.string.title_result1));
            txtDetail.setText(getResources().getString(R.string.text_detail));
        }else if (GlobalVars.DiAGNOSTIC == Covid.RESFRIADO){
            btnNext.setText(getResources().getText(R.string.title_finalizar));
            txtTitle.setText(getResources().getString(R.string.title_description_result_false));
            txtSubTitle.setText("");
            txtDetail.setText(getResources().getString(R.string.text_detail_false));
        }else if(GlobalVars.DiAGNOSTIC == Covid.SANO){
            btnNext.setText(getResources().getText(R.string.title_finalizar));
            txtTitle.setText(getResources().getString(R.string.title_description_result_fine));
            txtSubTitle.setText("");
            txtDetail.setText(getResources().getString(R.string.text_detail_ok));
        }
    }
}

