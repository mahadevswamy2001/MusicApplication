package com.example.dmeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dmeo.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users findByEmail(String email);

}
