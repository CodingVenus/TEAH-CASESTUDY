package org.venus_teah_poketeam_casestudy.security.repository;

import org.venus_teah_poketeam_casestudy.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String Email);
}
