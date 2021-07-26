package com.example.crime;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterFragment extends Fragment{
    EditText fullname, email, password, cpassword;
    Button btn_register;
    DatabaseHelper db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        fullname = view.findViewById(R.id.et_name);
        email = view.findViewById(R.id.et_email);
        password = view.findViewById(R.id.et_password);
        cpassword = view.findViewById(R.id.et_repassword);

        btn_register = view.findViewById(R.id.btn_register);
        db = new DatabaseHelper(this.getContext());

        LoginFragment loginFragment = new LoginFragment();


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEmail = email.getText().toString();
                String userName = fullname.getText().toString();
                String userPassword = password.getText().toString();
                String userCpassword = cpassword.getText().toString();

                if (userName.equals("") || userEmail.equals("") || userPassword.equals("") || userCpassword.equals(""))
                    Toast.makeText(getActivity(), "Please fill all the inputs", Toast.LENGTH_SHORT).show();
                else{
                    if(userPassword.equals(userCpassword)){
                        Boolean checkUser = db.doesUserExist(userEmail);
                        if (checkUser == false){
                            db.insertData(userEmail, userName, userPassword);

                            //changeFragment.changeFragment();
                            Intent intent = new Intent(getActivity(), ListeActivity.class);
                            startActivity(intent);
                        } else
                            Toast.makeText(getActivity(), "This username is already taken!! choose another", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getActivity(), "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }
}