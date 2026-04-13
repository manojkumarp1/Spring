package com.mk.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.springbootapp.model.AuthenticationRequest;
import com.mk.springbootapp.utility.JWTUtil;

@RestController
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JWTUtil jwtUtil;

	@PostMapping("/authenticate")
	public String generateToken(AuthenticationRequest authenticationRequest) {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			jwtUtil.generateToken(authenticationRequest.getUsername());
			return jwtUtil.generateToken(authenticationRequest.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
