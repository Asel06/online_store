package com.store.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "address", schema = "store")
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "house", nullable = false)
    private int house;

    @Column(name = "apartment", nullable = false)
    private int apartment;



}
