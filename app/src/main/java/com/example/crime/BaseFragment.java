package com.example.crime;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public abstract class BaseFragment extends FragmentActivity {

    public abstract Fragment createTypeFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.hebergeur);

        if(fragment==null)
        {
            fragment = createTypeFragment();
            fm.beginTransaction().add(R.id.hebergeur,fragment).commit();
        }
    }
}
