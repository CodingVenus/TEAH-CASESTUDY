package com.example.venus_teah_poketeam_casestudy.repository;

import com.example.venus_teah_poketeam_casestudy.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

}
