package com.keysafe.model;

import java.util.Date;

public class Ticket {
    private int id;
    private String title;
    private String body;
    private int userId;
    private int staffId;
    private String status;
    private Date dateCreated;
    private Date lastUpdated;

    public Ticket(int id, String title, String body, int userId, int staffId, String status, Date dateCreated, Date lastUpdated) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.staffId = staffId;
        this.status = status;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public void showInfo() {
        System.out.println("\n----------");
        System.out.println("Ticket: " + this.title);
        System.out.println("\n" + this.body);
        System.out.println("\nÚltima actualización: " + this.lastUpdated);
        System.out.println("\nCreado: " + this.dateCreated);
        System.out.println("----------\n");
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getUserId() {
        return userId;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getStatus() {
        return status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }
}
