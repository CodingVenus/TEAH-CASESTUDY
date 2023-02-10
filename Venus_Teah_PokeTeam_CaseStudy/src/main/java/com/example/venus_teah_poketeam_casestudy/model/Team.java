package com.example.venus_teah_poketeam_casestudy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    //MAPPING TO TRAINER LIST
    //ONE TO MANY
    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Trainer> trainerList;

}
