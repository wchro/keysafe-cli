package com.keysafe.model;

import com.keysafe.KeySafe;
import com.keysafe.util.Database;
import com.keysafe.util.QuickCommands;

import java.util.ArrayList;
import java.util.Date;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected Boolean loginStatus;
    protected Date registerDate;
    private Database db = KeySafe.db;

    public User(int id, String name, String email, Date registerDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registerDate = registerDate;

    }

    // Get user's name
    public String getName() {
        return this.name;
    }

    // Get user's credentials
    public ArrayList<Credential> getCredentials() {
        ArrayList<Credential> credentials = new ArrayList<>();
        ArrayList<String[]> result = db.getData("SELECT * FROM credentials WHERE userId = %s".formatted(this.id));

        for (int i = 0; i < result.size(); i++) {
            // Format data
            int id = Integer.parseInt(result.get(i)[0]);
            String type = result.get(i)[1];
            String name = result.get(i)[2];
            Date dateCreated = QuickCommands.parseDate(result.get(i)[13]);
            Date lastUpdated = QuickCommands.parseDate(result.get(i)[14]);

            Credential credential = new Credential(id, name, type, dateCreated, lastUpdated);

            credentials.add(credential);
        }
        return credentials;
    };

    // Add new login
    public void addCredential(String name, String email, String password, String site) {
        Date date = new Date();
        db.insertData(("INSERT INTO credentials (category, name, email, password, site, userId, dateCreated, lastUpdated)" +
                "VALUES ('login', '%s', '%s', '%s', '%s', %s, '%s', '%s')")
                .formatted(name, email, password, site, this.id, date, date));
    }

    // Add new credit card

    public void addCard(String name, String brand, String cardHolder, String number, String expMonth, String expYear, String cvv) {
        Date date = new Date();
        db.insertData(("INSERT INTO credentials (category, name, brand, cardHolder, number, expMonth, expYear, cvv, userId, dateCreated, lastUpdated)" +
                "VALUES ('card', '%s', '%s', '%s', '%s', %s, '%s', '%s', %s, '%s', '%s')")
                .formatted(name, brand, cardHolder, number, expMonth, expYear, cvv, this.id, date, date));
    }
}

