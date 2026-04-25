package com.mk.springbootapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mk.springbootapp.model.Role;
import com.mk.springbootapp.model.Users;
import com.mk.springbootapp.repository.UserDetailsRepository;

@Configuration
public class DataLoader {

	@Bean
	CommandLineRunner init(UserDetailsRepository repo, PasswordEncoder encoder) {
		return args -> {

			String username = "admin";

			if (repo.findByUsername(username).isEmpty()) {

				Users user = new Users();
				user.setUsername(username);
				user.setPassword(encoder.encode("test"));
				user.setRole(Role.ADMIN);

				repo.save(user);

				System.out.println("User saved successfully!");
			} else {
				System.out.println("User already exists!");
			}

			if (repo.findByUsername("manoj").isEmpty()) {

				Users user = new Users();
				user.setUsername("manoj");
				user.setPassword(encoder.encode("test"));
				user.setRole(Role.USER);

				repo.save(user);

				System.out.println("User saved successfully!");
			} else {
				System.out.println("User already exists!");
			}
		};
	}
}