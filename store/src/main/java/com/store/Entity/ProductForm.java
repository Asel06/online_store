package com.store.entity;

public class ProductForm {
    private String name;
    private int price;
    private int quantity;
    private int manufactor;
    private int category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getManufactor() {
        return manufactor;
    }

    public void setManufactor(int manufactor) {
        this.manufactor = manufactor;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
