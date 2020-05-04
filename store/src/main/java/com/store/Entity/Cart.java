package com.store.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart", schema = "store")
public class Cart {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="user",  referencedColumnName = "id")
    private User user;

    @Column(name = "price", nullable = false)
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
