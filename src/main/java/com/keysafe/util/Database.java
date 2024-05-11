// FAKE Database

package com.keysafe.util;

import java.sql.*;
import java.util.ArrayList;


public class Database {
    private Connection connection;
    private String db;

    public Database(String db) {
        this.db = "jdbc:sqlite:" + db;
        // Create tables if not exists
        try {
            this.connection = DriverManager.getConnection(this.db);
            Statement statement = this.connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(255), email VARCHAR(255) UNIQUE, password VARCHAR(255), loginStatus BOOL, registerDate VARCHAR(255))");
            statement.execute("CREATE TABLE IF NOT EXISTS credentials (id INTEGER PRIMARY KEY AUTOINCREMENT, category VARCHAR(255), name VARCHAR(255), email VARCHAR(255), password VARCHAR(255), site VARCHAR(255), brand VARCHAR(255), cardholder VARCHAR(255), number VARCHAR(255), expMonth VARCHAR(255), expYear VARCHAR(255), cvv VARCHAR(255), userId INTEGER, dateCreated VARCHAR(255), lastUpdated VARCHAR(255))");
            statement.close();
            this.connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    ;

    // Insert SQL
    public void insertData(String sql) {
        try {
            this.connection = DriverManager.getConnection(this.db);
            Statement statement = this.connection.createStatement();
            statement.execute(sql);
            statement.close();
            this.connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Get data
    public ArrayList<String[]> getData(String sql) {
        ResultSet res = null;
        ArrayList<String[]> result = new ArrayList<>();
        try {
            this.connection = DriverManager.getConnection(this.db);
            Statement statement = this.connection.createStatement();
            res = statement.executeQuery(sql);
            int columnCount = res.getMetaData().getColumnCount();
            while (res.next()) {
                String[] row = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = res.getString(i + 1);
                }
                result.add(row);
            }
            statement.close();
            this.connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


}