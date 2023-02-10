package com.example.venus_teah_poketeam_casestudy.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Entity
@Table
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;



}
