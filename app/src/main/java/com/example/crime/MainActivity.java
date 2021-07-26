package com.example.crime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends  BaseFragment {


    @Override
    public Fragment createTypeFragment() {
        return new CrimeFragment();
    }
}