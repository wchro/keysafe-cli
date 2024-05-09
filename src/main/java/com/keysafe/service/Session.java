package com.keysafe.service;

import com.keysafe.model.User;
import com.keysafe.util.Database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Session {
    public User user;
    static Database db = new Database("keysafe.db");

    //    Login
     public boolean login(String email, String password) {
         ArrayList<String[]> result = db.getData("SELECT * FROM users WHERE email = '%s' LIMIT 1".formatted(email));

         if (result.isEmpty()) return false;

         // Data from database
         String[] user = result.getFirst();
         int id = Integer.parseInt(user[0]);
         String name = user[1];
         String email_db = user[2];
         String password_db = user[3];
         Date registerDate;
         try {
             registerDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(user[5]);
         } catch (ParseException e) {
             registerDate = new Date();
         }

         if (password.equals(password_db)) {
             this.user = new User(id, name, email_db, registerDate);
         };

        return isLogged();
    };

    //    Register
    public void register(String email, String name, String password) {
        String date = new Date().toString();
        db.insertData("INSERT INTO users (name, email, password, loginStatus, registerDate) VALUES ('%s', '%s', '%s', false,' %s')".formatted(name, email, password, date));
    };


    // Logout
    public boolean logout() {
        this.user = null;
        return isLogged();
    };

    // Check session
    public boolean isLogged() {
        return this.user != null;
    };
}
