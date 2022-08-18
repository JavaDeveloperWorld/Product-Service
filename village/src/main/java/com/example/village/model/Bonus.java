package com.example.village.model;

public class Bonus {
    private int id;
    private Customer customer;
    private float bonus;
    private String position;
    private int status;

    public Bonus(int id, Customer customer, float bonus, String position, int status) {
        this.id = id;
        this.customer = customer;
        this.bonus = bonus;
        this.position = position;
        this.status = status;
    }

    public Bonus() {
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

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
