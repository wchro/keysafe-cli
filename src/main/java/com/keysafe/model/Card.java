package com.keysafe.model;

import java.util.Date;

public class Card extends Credential {
    private final String brand;
    private final String cardHolder;
    private final long number;
    private final int expMonth;
    private final int expYear;
    private final int cvv;

    public Card(int id, String name, String category, Date dateCreated, Date lastUpdated, String brand, String cardHolder, long number, int expMonth, int expYear, int cvv) {
        super(id, name, category, dateCreated, lastUpdated);
        this.brand = brand;
        this.cardHolder = cardHolder;
        this.number = number;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.cvv = cvv;
    }

    @Override
    public void showInfo() {
        System.out.println("\n----------");
        System.out.println("Credencial: " + this.getName());
        System.out.println("\n" + this.brand);
        System.out.println("Propietario: " + this.cardHolder);
        System.out.println("Numero: " + this.number);
        System.out.println("Fecha de expiración: %s/%s ".formatted(this.expMonth, this.expYear));
        System.out.println("CVV: " + this.cvv);
        System.out.println("\nModificada: " + this.getLastUpdated());
        System.out.println("Creada: " + this.getDateCreated());
        System.out.println("----------\n");
    }
}
