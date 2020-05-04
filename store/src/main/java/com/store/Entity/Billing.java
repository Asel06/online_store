package com.store.entity;

import javax.persistence.*;

@Entity
@Table(name = "billing", schema = "store")
public class Billing {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="user_id",  referencedColumnName = "id")
    private User user;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="address",  referencedColumnName = "id")
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
