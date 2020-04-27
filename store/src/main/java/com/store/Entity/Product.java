package com.store.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table (name = "product", schema = "store")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    @Min(0)
    private int price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="manufactor",  referencedColumnName = "id")
    private Manufactor manufactor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="category",  referencedColumnName = "id")
    private Category category;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Manufactor getManufactor() {
        return manufactor;
    }

    public void setManufactor(Manufactor manufactor) {
        this.manufactor = manufactor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
