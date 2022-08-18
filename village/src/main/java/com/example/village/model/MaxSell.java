package com.example.village.model;

public class MaxSell {
    private int id;
    private SubProduct subProduct;
    private int maxCount;

    public MaxSell(int id,SubProduct subProduct, int maxCount) {
        this.id = id;
        this.subProduct = subProduct;
        this.maxCount = maxCount;
    }
    public MaxSell(){

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

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
}
