package com.example.jamal.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jamal on 29/03/2018.
 */

public class PersonDAO {
    public static String CIN="cin";
    public static String NOM="nom";
    public static String PRENOM="prenom";
    private Person person ;

    protected final static int VERSION = 2;
    // Le nom du fichier qui représente ma base
    protected final static String DB = "database.db";

    protected SQLiteDatabase mDb = null;
    protected DbHandler mHandler = null;

    public PersonDAO(Context context) {
        this.mHandler= new DbHandler(context,DB,null, VERSION);
        this.mDb=open();
    }

    public SQLiteDatabase open(){
        this.mDb=this.mHandler.getWritableDatabase();
        return this.mDb;
    }
    public void close(){
        mDb.close();
    }
    public SQLiteDatabase getDatabase(){
        return mDb;
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
