package com.mk.springbootapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.springbootapp.model.Users;

@Repository
public interface UserDetailsRepository extends JpaRepository<Users, Long> {
	Optional<Users> findByUsername(String username);
}
