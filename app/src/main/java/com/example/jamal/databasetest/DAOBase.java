package com.example.jamal.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

/**
 * Created by jamal on 15/02/2018.
 */

public class DAOBase {
    protected final static int VERSION = 2;
    // Le nom du fichier qui représente ma base
    protected final static String NOM = "database.db";

    protected SQLiteDatabase mDb = null;
    protected DbHandler mHandler = null;

    public DAOBase(Context context) {
        this.mHandler= new DbHandler(context,NOM,null, VERSION);
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
}
