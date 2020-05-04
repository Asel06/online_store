package com.store.entity;

import javax.persistence.*;

@Entity
@Table (name = "order", schema = "store")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="status",  referencedColumnName = "id")
    private Status status;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="address",  referencedColumnName = "id")
    private Address address;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="payment",  referencedColumnName = "id")
    private Payment payment;

    @Column(name = "price", nullable = false)
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
