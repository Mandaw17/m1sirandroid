package com.example.crime;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DepotCrime {
    public static DepotCrime depotCrime;
    private List<Crime> crimeList;

    public static DepotCrime getCrime(Context context) {
        if(depotCrime==null)
        {
            depotCrime = new DepotCrime();
        }
        return depotCrime;
    }

    private DepotCrime()
    {
        crimeList = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime("Crime Numero :"+i, i);
            crimeList.add(crime);
        }
    }

    public List<Crime> getCrimeList() {
        return crimeList;
    }

    public Crime getCrimeFromId(UUID id){
        for (int i = 0; i < crimeList.size() ; i++) {
            if(crimeList.get(i).getIdCrime().equals(id)) return crimeList.get(i);
        }
        return null;
    }
}
