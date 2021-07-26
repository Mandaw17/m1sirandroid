package com.example.crime;

import java.util.Date;
import java.util.UUID;

public class Liste {
    private UUID idListe;
    private Date date;

    public  Liste()
    {
        idListe = UUID.randomUUID();
        date = new Date();
    }

    public UUID getIdListe() {
        return idListe;
    }

    public Date getDate() {
        return date;
    }

}
