package org.venus_teah_poketeam_casestudy.model;

import org.venus_teah_poketeam_casestudy.security.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Trainer  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "You must provide a name.")
    @NotNull(message = "You must provide a name.")
    @Size(min=2, max=50, message = "You must provide a name.")
    @Column(name = "name")
    private String name;


    @NotEmpty(message = "You must select a hometown")
    @NotNull(message = "You must provide a hometown.")
    @Column(name = "hometown")
    private String hometown;


    @OneToOne
    @JoinColumn(name= "user_id")
    private User user;


    //MAPPING TO TEAM
    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;



    //MAPPING TO POKEMON
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE } )
    @JoinTable(name = "trainer_pokemon", joinColumns = @JoinColumn(name = "trainer_id"), inverseJoinColumns = @JoinColumn(name = "pokemon_id"))
    private List<Pokemon> pokemonList = new ArrayList<>();
}
