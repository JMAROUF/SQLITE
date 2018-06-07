package com.example.jamal.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jamal on 15/02/2018.
 */

public class DbHandler extends SQLiteOpenHelper {
    public static final String PERSON_CIN = "cin";
    public static final String PERSON_NOM = "nom";
    public static final String PERSON_PRENOM = "prenom";

    public static final String METIER_TABLE_NAME = "person";
    public static final String METIER_TABLE_CREATE =
            "CREATE TABLE " + METIER_TABLE_NAME + " (" +
                    PERSON_CIN + " TEXT PRIMARY KEY , " +
                    PERSON_NOM + " TEXT, " +
                    PERSON_PRENOM + " TEXT);";
    public static final String METIER_TABLE_DROP = "DROP TABLE IF EXISTS " + METIER_TABLE_NAME + ";";

    public DbHandler (Context context, String name, SQLiteDatabase.CursorFactory cursorFactory, int version){
        super(context,name,null,version);

    }
    // cette methode est automatiquement appelée aprés l'instanciation
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(METIER_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(METIER_TABLE_DROP);
        onCreate(db);
    }
}
