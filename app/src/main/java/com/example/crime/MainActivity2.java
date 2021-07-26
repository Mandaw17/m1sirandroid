package com.example.crime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;

public class MainActivity2 extends BaseFragment {


    @Override
    public Fragment createTypeFragment() {
        return new FragmentListe();
    }
}