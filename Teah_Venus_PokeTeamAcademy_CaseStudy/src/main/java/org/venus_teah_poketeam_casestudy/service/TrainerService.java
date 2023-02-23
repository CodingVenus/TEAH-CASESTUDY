package org.venus_teah_poketeam_casestudy.service;

import org.venus_teah_poketeam_casestudy.model.Trainer;
import org.venus_teah_poketeam_casestudy.repository.TrainerRepository;
import org.venus_teah_poketeam_casestudy.security.model.User;
import org.venus_teah_poketeam_casestudy.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    UserRepository userRepository;


    public Trainer saveTrainer(Trainer trainerObject) {
        return trainerRepository.save(trainerObject);
    }

    //POST
    public Trainer createTrainer(Trainer trainerObject) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userRepository.findByEmail(username); //current user

        trainerObject.setUser(user);
        user.setTrainer(trainerObject); //have to update user to reflect trainer id

//        userRepository.save(user); // dont need to save --- creates duplicate entries
        return trainerRepository.save(trainerObject);

    }


    //GET BY ID
    public Optional<Trainer> getTrainerById(Long trainerId) {

        return trainerRepository.findById(trainerId);

    }

    //GET ALL
    public List<Trainer> getAllTrainers() {

        return trainerRepository.findAll();
    }


    //UPDATE
    public Trainer updateTrainer(Long trainerId, Trainer trainerObject) {

        Trainer existingTrainer = trainerRepository.findById(trainerId).get();
        existingTrainer.setName(trainerObject.getName());

        return trainerRepository.save(existingTrainer);

    }

    //DELETE
    //BY ID
    public void deleteTrainerById(Long trainerId) {

        trainerRepository.deleteById(trainerId);
    }

    //ALL
    public void deleteAllTrainers() {

        trainerRepository.deleteAll();
    }


}
