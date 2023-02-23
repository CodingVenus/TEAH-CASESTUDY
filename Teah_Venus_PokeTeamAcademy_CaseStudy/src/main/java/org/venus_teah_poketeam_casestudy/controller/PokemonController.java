package org.venus_teah_poketeam_casestudy.controller;

import org.venus_teah_poketeam_casestudy.model.Pokemon;
import org.venus_teah_poketeam_casestudy.model.Trainer;
import org.venus_teah_poketeam_casestudy.security.model.User;
import org.venus_teah_poketeam_casestudy.security.service.UserService;
import org.venus_teah_poketeam_casestudy.service.PokemonService;
import org.venus_teah_poketeam_casestudy.service.TrainerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Transactional
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @Autowired
    UserService userService;

    @Autowired
    TrainerService trainerService;

    /**RETURNS POKEMON CHOICE PAGE**/
    @RequestMapping("/pokemon/selection")
    public String getPokemonPage(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);

        return "pokemon_choice";
    }


    /**DELETES POKEMON CONNECTION TO TRAINER WHILE KEEPING IT IN THE DB**/
    @RequestMapping("/pokemon/delete/{name}")
    public String deletePokemon(@PathVariable("name") String pokemonName) {

        //RETRIEVE CURRENT TRAINER
        Trainer trainer = userService.getCurrentUser().getTrainer();

        Pokemon selectedPokemon = pokemonService.getPokemonByName(pokemonName);

        List<Pokemon> pokemonList = trainer.getPokemonList();
        pokemonList.remove(selectedPokemon);

        //SAVE UPDATED TRAINER
        trainerService.saveTrainer(trainer);

        return "redirect:/";
    }

    /**SAVES POKEMON TO DB AND SETS TO TRAINER**/
    @RequestMapping("/pokemon/{name}/{id}") //having post-mapping gives error. changed to request
    public String savePokemon(@PathVariable("name") String name, @PathVariable("id") Long id, Model model) {

        //CREATING NEW POKEMON ENTITY -- *** ADD TO SERVICE CLASS
        Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setId(id);
        pokemonService.savePokemon(pokemon);

        //RETRIEVE CURRENT TRAINER
        Trainer trainer = userService.getCurrentUser().getTrainer();

        //SET POKEMON TO TRAINER
        List<Pokemon> pokemonList = trainer.getPokemonList();
        pokemonList.add(pokemon);

        //SAVE UPDATED TRAINER
        trainerService.saveTrainer(trainer);

        //SET POKEMON TO TRAINER

        model.addAttribute("pokemon", pokemon);
        return "redirect:/pokemon/selection";
    }
}
