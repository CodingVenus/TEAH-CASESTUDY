package org.venus_teah_poketeam_casestudy.security.service;


import org.venus_teah_poketeam_casestudy.security.model.CustomUserDetails;
import org.venus_teah_poketeam_casestudy.security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUserDetailsService extends UserDetailsService {

	User save(CustomUserDetails customUserDetails);

}
