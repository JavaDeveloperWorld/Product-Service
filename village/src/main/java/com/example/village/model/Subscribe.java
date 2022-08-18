package com.example.village.model;

public class Subscribe {
    private int id;
    private String mail;
    private byte check;
    private String date;
    private byte status;

    public Subscribe(int id, String mail, byte check, String date, byte status) {
        this.id = id;
        this.mail = mail;
        this.check = check;
        this.date = date;
        this.status = status;
    }

    public Subscribe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public byte getCheck() {
        return check;
    }

    public void setCheck(byte check) {
        this.check = check;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
