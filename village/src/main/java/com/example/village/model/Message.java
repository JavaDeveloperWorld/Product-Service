package com.example.village.model;

public class Message {
    private int id;
    private Customer customer;
    private String message;
    private String answer;
    private int read;
    private String date;
    private int status;

    public Message(int id, Customer customer, String message, String answer, int read, String date, int status) {
        this.id = id;
        this.customer = customer;
        this.message = message;
        this.answer = answer;
        this.read = read;
        this.date = date;
        this.status = status;
    }

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
