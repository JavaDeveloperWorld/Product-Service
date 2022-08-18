package com.example.village.model;

public class Product {
    private int id;
    private String name;
    private String description;
    private String photo;
    private int status;

    public Product(int id, String name, String description, String photo,int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.status=status;
    }
    public Product(){}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
