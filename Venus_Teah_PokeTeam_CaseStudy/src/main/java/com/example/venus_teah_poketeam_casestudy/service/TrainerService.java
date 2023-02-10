package com.example.venus_teah_poketeam_casestudy.service;

import com.example.venus_teah_poketeam_casestudy.model.Trainer;
import com.example.venus_teah_poketeam_casestudy.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
    @Autowired
    TrainerRepository trainerRepository;

    //POST
    public Trainer createTrainer(Trainer trainerObject) {

        return trainerRepository.save(trainerObject);

    }


    //GET
        //BY ID
    public Optional<Trainer> getTrainerById(Long trainerId) {

        return trainerRepository.findById(trainerId);

    }

        //ALL
    public List<Trainer> getAllTrainers() {

        return trainerRepository.findAll();
    }



    //UPDATE
    public void updateTrainer(Long trainerId, Trainer trainerObject) {
        Optional<Trainer> trainerData = trainerRepository.findById(trainerId);
        if (trainerData.isPresent()) {
            Trainer updatedTrainer = trainerData.get();
            updatedTrainer.setName(trainerObject.getName());

            trainerRepository.save(updatedTrainer);
        }
    }



    //DELETE
        //BY ID
    public void deleteTrainerById(Long trainerId) {

        trainerRepository.deleteById(trainerId);
    }

        //ALL
    public void deleteAllTrainer() {

        trainerRepository.deleteAll();
    }


}
