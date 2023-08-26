package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	//finder method to load user details by name
	Optional<UserEntity> findByUserName(String userName);
	
}
