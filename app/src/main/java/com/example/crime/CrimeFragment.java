package com.example.crime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.UUID;

public class CrimeFragment extends Fragment {
    EditText titre;
    Button dateBtn;
    CheckBox chekBox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.crime_layout,container,false);
        titre = view.findViewById(R.id.titreCrime);
        dateBtn = view.findViewById(R.id.btnDate);
        chekBox = view.findViewById(R.id.idCheck);

        getIntentData();

        return  view ;
    }

    public void getIntentData(){
        UUID id;
        id = (UUID) getActivity().getIntent().getSerializableExtra("id");
        Crime crime = DepotCrime.depotCrime.getCrimeFromId(id);
        dateBtn.setText("crime.getDate().toString()");
    }
}
