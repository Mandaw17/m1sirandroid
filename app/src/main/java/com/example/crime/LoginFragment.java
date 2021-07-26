package com.example.crime;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crime.DatabaseHelper;
import com.example.crime.R;

import java.util.Date;

public class LoginFragment extends Fragment {
    EditText email, password;
    Button btn_login;
    DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        email = view.findViewById(R.id.et_email);
        password = view.findViewById(R.id.et_password);
        btn_login = view.findViewById(R.id.btn_login);
        db = new DatabaseHelper(this.getContext());


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = email.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(getActivity(), "Please fill all the inputs", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkUsernamePassword = db.CheckEmailPassword(user, pass);
                    if (checkUsernamePassword == false) {
                        Toast.makeText(getActivity(), "Try Again", Toast.LENGTH_SHORT).show();
                    }else{
                        //db.addList();
                        Intent intent = new Intent(getActivity(),ListeActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        return view;
    }
}