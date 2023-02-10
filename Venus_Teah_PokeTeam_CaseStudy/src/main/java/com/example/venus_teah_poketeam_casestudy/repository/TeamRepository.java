package com.example.venus_teah_poketeam_casestudy.repository;

import com.example.venus_teah_poketeam_casestudy.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
