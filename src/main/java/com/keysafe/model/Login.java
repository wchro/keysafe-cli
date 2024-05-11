package com.keysafe.model;

import java.util.Date;

public class Login extends Credential {
    private final String email;
    private final String password;
    private final String site;

    public Login(int id, String name, String category, Date dateCreated, Date lastUpdated, String email, String password, String site) {
        super(id, name, category, dateCreated, lastUpdated);
        this.email = email;
        this.password = password;
        this.site = site;
    }

    @Override
    public void showInfo() {
        System.out.println("\n----------");
        System.out.println("Credencial: " + this.getName());
        System.out.println("\nURL: " + this.site);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.site);
        System.out.println("\nModificado: " + this.getLastUpdated());
        System.out.println("Creado: " + this.getDateCreated());
        System.out.println("----------\n");
    }
}
