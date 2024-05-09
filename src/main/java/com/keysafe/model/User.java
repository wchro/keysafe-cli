package com.keysafe.model;

import com.keysafe.util.Database;

import java.util.ArrayList;
import java.util.Date;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected Boolean loginStatus;
    protected Date registerDate;
    private Database db;

    public User(int id, String name, String email, Date registerDate, Database db) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registerDate = registerDate;
        this.db = db;

    }

    // Get user's name
    public String getName() {
        return this.name;
    }

    // Get user's credentials
//    public ArrayList<String[]> getCredentials() {
//        //
//        ArrayList<String[]> result = db.getData()
//    }

    // Add new web credential
    public void addCredential(String name, String email, String password, String site) {
        Date date = new Date();
        db.insertData(("INSERT INTO credentials (category, name, email, password, site, userId, dateCreated, lastUpdated)" +
                "VALUES ('web', '%s', '%s', '%s', '%s', %s, '%s', '%s')")
                .formatted(name, email, password, site, this.id, date, date));
    }
}

