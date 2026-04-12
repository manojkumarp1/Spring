package com.mk.springbootapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mk.springbootapp.repository.UserDetailsRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDetailsRepository userDetailsRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return userDetailsRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("user Not Found"));
	}

}
