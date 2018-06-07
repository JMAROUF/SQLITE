package com.example.jamal.databasetest;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    ListView maListe;
    Cursor c;
    PersonDAO personDao;
    Person p ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maListe= findViewById(R.id.maListe);
        personDao = new PersonDAO(getApplicationContext());
        p= new Person();
        p.setCin("b123456");
        p.setNom("ahmed");
        p.setPrenom("ahmed");
        personDao.ajouterPerson(p);

        p.setCin("b789456");
        p.setNom("yassine");
        p.setPrenom("yassine");
        personDao.ajouterPerson(p);

        p.setCin("b1012131");
        p.setNom("alae");
        p.setPrenom("alae");
        personDao.ajouterPerson(p);
        c=personDao.getCursor();
        //
        //on affecte le curseur à notre listView , le premier champ doit commencer par _id
        maListe.setAdapter(new SimpleCursorAdapter (getApplicationContext(), R.layout.cursor_row, c,
                new String[]{"_id", MetierDAO.NOM,MetierDAO.PRENOM}, new int[]{R.id.cin, R.id.nom,R.id.prenom})
        );

    }
}
