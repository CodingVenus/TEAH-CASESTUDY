package org.venus_teah_poketeam_casestudy.security.model;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id // sets field as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // provides a primary key generation strategy
    private Long id;
    private String name;

    public Role() {
    }

    public Role(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}