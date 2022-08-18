package com.example.village.model;

public class Balans {
    private int id;
    private Customer customer;
    private float payment;
    private float balance;
    private String date;
    private int status;

    public Balans(int id, Customer customer, float payment, float balance, String date, int status) {
        this.id = id;
        this.customer = customer;
        this.payment = payment;
        this.balance = balance;
        this.date = date;
        this.status = status;
    }

    public Balans() {
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

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
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
