package com.keysafe.model;

import com.keysafe.util.Database;

import java.util.Date;

public class Staff extends User {
    public Staff(int id, String name, String email, Date registerDate, Database db) {
        super(id, name, email, registerDate, db);
    }


    // Lock account
    public String lockAccount(int userId, String reason) {
        return "Locked";
    }

    // Unlock account
    public String unlockAccount(int userId) {
        return "Unlocked";
    }

    // Close account
    public String closeAccount(int userId) {
        return "Closed";
    }
}
