package com.latam.covid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.latam.covid.Enum.Covid;
import com.latam.covid.models.EQuestions;
import com.latam.covid.ui.adapters.OnItemClickListenerQuestions;
import com.latam.covid.ui.adapters.QuestionsAdapter;
import com.latam.covid.utils.Validation;

import java.util.ArrayList;
import java.util.List;

import Utils.GlobalVars;

public class FirstFragment extends Fragment {

    private List<EQuestions> listQuestiosn = new ArrayList<EQuestions>();
    private RecyclerView revDiagnostic;
    private RecyclerView.LayoutManager layoutManager;
    private QuestionsAdapter dAdapter;
    private Button btnDiagnostic;



    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_first, container, false);
        // Inflate the layout for this fragment
              //button_first
        btnDiagnostic = (Button) root.findViewById(R.id.button_first);
        revDiagnostic = (RecyclerView)root.findViewById(R.id.rcv_diagnostic);
        revDiagnostic.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        revDiagnostic.setLayoutManager(layoutManager);
        loadMainList();
        dAdapter = new QuestionsAdapter(listQuestiosn, getActivity());
        revDiagnostic.setAdapter(dAdapter);


/*        btnDiagnostic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dAdapter.getSelected();
                //
            }
        });*/

        return root;


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<EQuestions> listQ = new ArrayList<>();
                listQ.addAll(dAdapter.getSelected());
                Validation val = new Validation();
                val.isCovid(listQ);

               /* if (!resultCovid){
                   GlobalVars.DiAGNOSTIC = Covid.TRUE;
               }else {
                   GlobalVars.DiAGNOSTIC = Covid.FALSE;
               }*/

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    public void loadMainList(){

        listQuestiosn.clear();
        listQuestiosn.add(0, new EQuestions(getString(R.string.title_falta),true, false, true));
        listQuestiosn.add(1, new EQuestions(getString(R.string.title_fiebre), false, false, true));
        listQuestiosn.add(2, new EQuestions(getString(R.string.title_tos), false, false, true));
        listQuestiosn.add(3, new EQuestions(getString(R.string.title_contacto), true, false, true ));
        listQuestiosn.add(4, new EQuestions(getString(R.string.title_mucosidad), false, false,false));
        listQuestiosn.add(5, new EQuestions(getString(R.string.title_dolor), false, false, true));
        listQuestiosn.add(6, new EQuestions(getString(R.string.title_malestar), false, false, false));
        listQuestiosn.add(7, new EQuestions(getString(R.string.title_20_dias), false,false, false));

    }


}
