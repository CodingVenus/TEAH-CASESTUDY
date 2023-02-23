package org.venus_teah_poketeam_casestudy.security.service;


import org.venus_teah_poketeam_casestudy.security.model.CustomUserDetails;
import org.venus_teah_poketeam_casestudy.security.model.User;
import org.venus_teah_poketeam_casestudy.security.model.Role;
import org.venus_teah_poketeam_casestudy.security.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

	//this is a userdetailservice object
	private UserRepository userRepository;
	
	public CustomUserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	// saves user's registration data to the database
//	@Override
//	public User save(UserRegistrationDto registrationDto) {
//		User user = new User(
//				registrationDto.getEmail(),
//				new BCryptPasswordEncoder().encode(registrationDto.getPassword()),
//				registrationDto.getFirstName(),
//				registrationDto.getLastName(),
//				Arrays.asList(new Role("ROLE_USER")));
//
//		return userRepository.save(user);
//	}

	@Override
	public User save(CustomUserDetails customUserDetails) {
		User user = new User(
				customUserDetails.getEmail(),
				new BCryptPasswordEncoder().encode(customUserDetails.getPassword()),
				customUserDetails.getFirstName(),
				customUserDetails.getLastName(),
				Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid Username or Password.");
		}
//		return CustomUserDetails.getUser(user.getEmail(), )

		return new org.springframework.security.core.userdetails
				.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoleList()));
					
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
	}

}
