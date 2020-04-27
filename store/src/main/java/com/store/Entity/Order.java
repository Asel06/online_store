package com.store.Entity;

import javax.persistence.*;

@Entity
@Table (name = "order", schema = "store")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "address", nullable = false)
    private int address;

    @Column(name = "payment", nullable = false)
    private int payment;

    @Column(name = "price", nullable = false)
    private int price;
}
