package com.example.crime;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DepotListe {
    public static DepotListe depotListe;
    private List<Liste> listeList;

    public static DepotListe getListe(Context context) {
        if(depotListe==null)
        {
            depotListe = new DepotListe();
        }
        return depotListe;
    }

    private DepotListe()
    {
        listeList = new ArrayList<Liste>();
        for (int i = 0; i < 5; i++) {
            Liste liste = new Liste();
            listeList.add(liste);
        }
    }

    public List<Liste> getListeList() {
        return listeList;
    }

    public Liste getListeFromId(UUID id){
        for (int i = 0; i < listeList.size() ; i++) {
            if(listeList.get(i).getIdListe().equals(id)) return listeList.get(i);
        }
        return null;
    }
}
