package com.example.village.model;

public class Store {
    private int id;
    private SubProduct subProduct;
    private float count;
    private float maxCount;
    private float minCount;
    private int status;

    public Store(int id, SubProduct subProduct, float count,float maxCount,float minCount, int status) {
        this.id = id;
        this.subProduct = subProduct;
        this.count = count;
        this.maxCount=maxCount;
        this.minCount=minCount;
        this.status = status;
    }

    public Store() {
    }

    public float getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(float maxCount) {
        this.maxCount = maxCount;
    }

    public float getMinCount() {
        return minCount;
    }

    public void setMinCount(float minCount) {
        this.minCount = minCount;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
