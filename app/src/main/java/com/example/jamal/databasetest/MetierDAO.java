package com.example.jamal.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.jar.Attributes;

/**
 * Created by jamal on 15/02/2018.
 */

public class MetierDAO extends DAOBase {
    public static String CIN="cin";
    public static String NOM="nom";
    public static String PRENOM="prenom";
    private Person person ;

    public MetierDAO(Context context) {
        super(context);
    }
    public void ajouterPerson(Person p){
        ContentValues values = new ContentValues();
        values.put(CIN,p.getCin());
        values.put(NOM,p.getNom());
        values.put(PRENOM,p.getPrenom());
        mDb.insert("person", null, values);
    }

    public Person getPeson(String cin ){
        person= new Person();
        Cursor c =  mDb.rawQuery("select "+CIN+"as _id,"+NOM+","+PRENOM+"from  person where cin = ?",new String[]{cin});
        person.setCin(c.getString(0));
        person.setNom(c.getString(1));
        person.setPrenom(c.getString(2));
        return  person;
    }
    public Cursor getCursor(){
        Cursor c =  this.mDb.rawQuery("select cin as _id,nom,prenom from person" ,new String[]{});
        return c;
    }
}
