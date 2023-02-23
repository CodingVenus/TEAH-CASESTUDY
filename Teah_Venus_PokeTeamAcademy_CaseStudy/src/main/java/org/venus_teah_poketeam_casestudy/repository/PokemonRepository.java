package org.venus_teah_poketeam_casestudy.repository;

import org.venus_teah_poketeam_casestudy.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository <Pokemon, Long> {

    Pokemon getPokemonByNameIgnoreCase(String name);



}
