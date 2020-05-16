package com.store.entity;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Entity
@Table (name = "role", schema = "store")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "role")
    private Set<User> user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
