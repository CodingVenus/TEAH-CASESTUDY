package org.venus_teah_poketeam_casestudy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Team must have a name.")
    @Column(name = "name", length = 50)
    private String name;

    //MAPPING TO TRAINER LIST
    @ToString.Exclude //stop circular reference caused by lombok
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Trainer> trainerList;
}
