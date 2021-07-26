package com.example.crime;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID idCrime;
    private int quantity;
    private String lib;
    private Boolean isDone;


    public  Crime(String lib, int quantity)
    {
        idCrime = UUID.randomUUID();
        this.quantity = quantity;
        this.lib = lib;
        isDone= false;
    }

    public UUID getIdCrime() {
        return idCrime;
    }


    public int getQuantity() {
        return quantity;
    }

    public String getLib() {
        return lib;
    }

    public Boolean getDone() {
        return isDone;
    }
}
