package com.example.venus_teah_poketeam_casestudy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity
@Table
public class Trainer  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;


    //MAPPING TO TEAM
    @ManyToOne
    @JsonIgnore
    private Team team;

}
