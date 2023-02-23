package org.venus_teah_poketeam_casestudy.service;

import org.venus_teah_poketeam_casestudy.model.Pokemon;
import org.venus_teah_poketeam_casestudy.repository.PokemonRepository;
import org.venus_teah_poketeam_casestudy.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    PokemonRepository pokemonRepository;
    TrainerService trainerService;
    UserService userService;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository, TrainerService trainerService, UserService userService) {
        this.pokemonRepository = pokemonRepository;
        this.trainerService = trainerService;
        this.userService = userService;
    }


    public Pokemon savePokemon(Pokemon pokemonObject) {

        return pokemonRepository.save(pokemonObject);

    }

    public Pokemon getPokemonByName(String name) {
        return pokemonRepository.getPokemonByNameIgnoreCase(name);
    }
}

