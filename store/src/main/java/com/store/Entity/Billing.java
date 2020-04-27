package com.store.Entity;

import javax.persistence.*;

@Entity
@Table(name = "billing", schema = "store")
public class Billing {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "address", nullable = false)
    private int address;
}
