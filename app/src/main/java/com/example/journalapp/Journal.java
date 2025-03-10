package com.example.journalapp;

import com.google.firebase.Timestamp;

public class Journal {
    private String title;
    private String thoughts;
    private String imageUrl;

    private String userId;
    private com.google.firebase.Timestamp timestamp;
    private String userName;

    public Journal() {
    }

    public Journal(String title, String imageUrl, String thoughts, String userId, String userName, Timestamp timesTamp) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.thoughts = thoughts;
        this.userId = userId;
        this.userName = userName;
        timestamp = timesTamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestampAdd) {
        timestamp = timestampAdd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
