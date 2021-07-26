package com.example.crime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DBNAME = "Project.db";

    public DatabaseHelper(Context context) {
        super(context, "Project.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(email TEXT primary key, name TEXT, password TEXT)");
        //db.execSQL("create table list(id int primary key, creation_date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
       // db.execSQL("drop table if exists list");
    }



    //THis allows me to insert the data in the db whenever everything works fine. The validations
    //are done below.

    public Boolean insertData (String email, String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("name", name);
        contentValues.put("password", password);
        long result = db.insert("users", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean addList (){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues1 = new ContentValues();
        ContentValues contentValues2 = new ContentValues();

        contentValues.put("id", 1);
        contentValues.put("date", String.valueOf(new Date()));
        contentValues1.put("id", 2);
        contentValues1.put("date", String.valueOf(new Date()));
        contentValues1.put("id", 3);
        contentValues1.put("date", String.valueOf(new Date()));

        long result = db.insert("list", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }



    // This one's aim is to verify if the user (email) you are trying to register doesn't  already exist

    public  Boolean doesUserExist(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }


    //This is the first validation. it's on the username
    public  Boolean checkUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }


    public Boolean CheckEmailPassword(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount() >0)
            return  true;
        else
            return false;
    }
/*
    public void addNewListe() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Liste liste = new Liste();
        values.put("id", String.valueOf(liste.getIdListe()));
        values.put("creation_date", String.valueOf(liste.getDate()));

        db.insert("list", null, values);
        db.close();
    }

    public ArrayList<Liste> getAllLists() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM list" , null);
        ArrayList<Liste> courseModalArrayList = new ArrayList<>();
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new Liste());
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        cursorCourses.close();
        return courseModalArrayList;
    }
*/

}
