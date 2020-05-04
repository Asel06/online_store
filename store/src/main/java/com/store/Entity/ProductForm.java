package com.store.entity;

public class ProductForm {
    private String name;
    private int price;
    private int quantity;
    private int manufactorId;
    private int categoryId;

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

    public int getManufactorId() {
        return manufactorId;
    }

    public void setManufactorId(int manufactorId) {
        this.manufactorId = manufactorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
