package com.keysafe.model;

import java.util.Date;

public class Card extends Credential {
    private final String brand;
    private final String cardHolder;
    private final int number;
    private final int expMonth;
    private final int expYear;
    private final int cvv;

    public Card(int id, String name, String category, Date dateCreated, Date lastUpdated, String brand, String cardHolder, int number, int expMonth, int expYear, int cvv) {
        super(id, name, category, dateCreated, lastUpdated);
        this.brand = brand;
        this.cardHolder = cardHolder;
        this.number = number;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.cvv = cvv;
    }
}
