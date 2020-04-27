package com.store.Entity;

import javax.persistence.*;

@Entity
@Table(name = "cart", schema = "store")
public class Cart {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user", nullable = false)
    private int user;

    @Column(name = "price", nullable = false)
    private int price;
}
