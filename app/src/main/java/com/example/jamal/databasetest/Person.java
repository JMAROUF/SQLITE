package com.example.jamal.databasetest;

/**
 * Created by jamal on 14/02/2018.
 */

public class Person {
    private String cin;
    private String nom;
    private String prenom ;

    public Person() {

    }

    public Person(String cin, String nom, String prenom) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
