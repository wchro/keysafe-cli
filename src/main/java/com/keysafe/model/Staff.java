package com.keysafe.model;

import java.util.Date;

public class Staff extends User {
    public Staff(int id, String name, String email, Date registerDate) {
        super(id, name, email, registerDate);
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
