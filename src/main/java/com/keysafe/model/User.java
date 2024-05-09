package com.keysafe.model;

import java.util.Date;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected Boolean loginStatus;
    protected Date registerDate;

    public User(int id, String name, String email, Date registerDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registerDate = registerDate;
    }

    public String getName() {
        return this.name;
    }
}

