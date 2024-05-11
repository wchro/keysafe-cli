package com.keysafe.model;

import com.keysafe.KeySafe;
import java.util.ArrayList;
import java.util.Date;

public class Credential {
    private int id;
    private String name;
    private String category;
    private Date dateCreated;
    private Date lastUpdated;

    public Credential(int id, String name, String category, Date dateCreated, Date lastUpdated) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public Login getLogin() {
            Login login = null;

            try {
                ArrayList<String[]> result = KeySafe.db.getData("SELECT * FROM credentials WHERE id = %s LIMIT 1".formatted(this.id));

                // Format data
                String email = result.getFirst()[3];
                String password = result.getFirst()[4];
                String site = result.getFirst()[5];

                login = new Login(this.id, this.name, this.category, this.dateCreated, this.lastUpdated, email, password, site);

            } catch (Exception _) {};

            return login;

    }

    public Card getCard() {
            Card card = null;

            try {
                ArrayList<String[]> result = KeySafe.db.getData("SELECT * FROM credentials WHERE id = %s LIMIT 1".formatted(this.id));
                // Format data
                String brand = result.getFirst()[6];
                String cardHolder = result.getFirst()[7];
                int number = Integer.parseInt(result.getFirst()[8]);
                int expMonth = Integer.parseInt(result.getFirst()[9]);
                int expYear = Integer.parseInt(result.getFirst()[10]);
                int cvv = Integer.parseInt(result.getFirst()[11]);

                card = new Card(this.id, this.name, this.category, this.dateCreated, this.lastUpdated, brand, cardHolder, number, expMonth, expYear, cvv);
            } catch (Exception _) {};

            return card;
        }


    // Get attributes
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public Date getLastUpdated() {
        return this.lastUpdated;
    }
};

