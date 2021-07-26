package com.example.crime;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class FirstFragment extends Fragment {

    RecyclerView recyclerView;
    Button addButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        //db.execSQL("SQL");
        ContentValues contentValues = new ContentValues();
        contentValues.put("id","uidddd");
        contentValues.put("name","Violation de domicile");
        contentValues.put("date",new Date().toString());
        contentValues.put("resolve",0);

        long i = db.insert("crimes",null,contentValues);
        if(i>-1) Toast.makeText(getActivity(),"Insertion réussie",Toast.LENGTH_LONG).show();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DepotListe depotListe = DepotListe.getListe(getActivity());
        FirstFragment.CrimeAdapter adapter = new FirstFragment.CrimeAdapter(depotListe.getListeList());
        recyclerView.setAdapter(adapter);


        return view;
    }

    public class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        UUID id;
        TextView date;

        public CrimeHolder(LayoutInflater inflater,ViewGroup parent)
        {
            super(inflater.inflate(R.layout.one_liste,parent,false));
            date = itemView.findViewById(R.id.dateOneRow);

            itemView.setOnClickListener(this::onClick);

        }

        public void bindView(Liste crime)
        {
            date.setText(crime.getDate().toString());
            id = crime.getIdListe();
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"Hello",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getActivity(),MainActivity2.class);
            intent.putExtra("id",id);
            startActivity(intent);
        }
    }


    class CrimeAdapter extends RecyclerView.Adapter<FirstFragment.CrimeHolder>
    {
        List<Liste> listCrime;

        public CrimeAdapter(List<Liste> listCrime)
        {
            this.listCrime = listCrime;
        }

        @NonNull
        @Override
        public FirstFragment.CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new FirstFragment.CrimeHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull FirstFragment.CrimeHolder holder, int position) {
            holder.bindView(listCrime.get(position));
        }

        @Override
        public int getItemCount() {
            return listCrime.size();
        }
    }
}