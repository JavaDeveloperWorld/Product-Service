package com.example.village.model;

public class ProductSubProduct {
    private String productName;
    private String subName;

    public ProductSubProduct(String productName, String subName) {
        this.productName = productName;
        this.subName = subName;
    }

    public ProductSubProduct() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
}
