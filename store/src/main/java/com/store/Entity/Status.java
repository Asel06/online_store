package com.store.Entity;


import javax.persistence.*;

@Entity
@Table(name = "status", schema = "store")
public class Status {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
}
