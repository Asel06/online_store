package com.store.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table (name = "user", schema = "store")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false)
    private int phone;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="address",  referencedColumnName = "id")
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="role",  referencedColumnName = "id")
    private Set<Role> role;

    public User() {}

    public User(User user){
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.role = user.getRole();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
