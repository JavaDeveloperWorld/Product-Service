package com.example.village.model;

public class UserTableSum {
    private float sum_price;
    private float sum_pay;
    private float sum_unpay;

    public UserTableSum(float sum_price, float sum_pay, float sum_unpay) {
        this.sum_price = sum_price;
        this.sum_pay = sum_pay;
        this.sum_unpay = sum_unpay;
    }

    public UserTableSum() {
    }

    public float getSum_price() {
        return sum_price;
    }

    public void setSum_price(float sum_price) {
        this.sum_price = sum_price;
    }

    public float getSum_pay() {
        return sum_pay;
    }

    public void setSum_pay(float sum_pay) {
        this.sum_pay = sum_pay;
    }

    public float getSum_unpay() {
        return sum_unpay;
    }

    public void setSum_unpay(float sum_unpay) {
        this.sum_unpay = sum_unpay;
    }
}
