package com.store.Entity;


import javax.persistence.*;

@Entity
@Table(name = "payment", schema = "store")
public class Payment {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "method", nullable = false)
    private String method;
}
