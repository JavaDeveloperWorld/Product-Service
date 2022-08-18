package com.example.village.model;

import java.sql.Date;

public class Selling {
    private int id;
    private Customer customer;
    private SubProduct subProduct;
    private float count;
    private float price;
    private float sum_price;
    private float unpaid;
    private float bonus;
    private String address;
    private String phone;
    private String  date;
    private int status;


    public Selling(int id, Customer customer, SubProduct subProduct, float count, float price, float sum_price,float unpaid,float bonus,String address,String phone, String  date,int status) {
        this.id = id;
        this.customer=customer;
        this.subProduct = subProduct;
        this.count = count;
        this.price = price;
        this.sum_price = sum_price;
        this.unpaid=unpaid;
        this.bonus=bonus;
        this.address=address;
        this.phone=phone;
        this.date = date;
        this.status=status;
    }

    public Selling() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(float unpaid) {
        this.unpaid = unpaid;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SubProduct getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(SubProduct subProduct) {
        this.subProduct = subProduct;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSum_price() {
        return sum_price;
    }

    public void setSum_price(float sum_price) {
        this.sum_price = sum_price;
    }

    public String  getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
    }
}