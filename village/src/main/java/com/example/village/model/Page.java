package com.example.village.model;

public class Page {
    private int id;
    private int customer_count;
    private int sells;
    private float bonus;
    private String note;

    public Page(int id, int customer_count, int sells, float bonus, String note) {
        this.id = id;
        this.customer_count = customer_count;
        this.sells = sells;
        this.bonus = bonus;
        this.note = note;
    }

    public Page() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_count() {
        return customer_count;
    }

    public void setCustomer_count(int customer_count) {
        this.customer_count = customer_count;
    }

    public int getSells() {
        return sells;
    }

    public void setSells(int sells) {
        this.sells = sells;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
