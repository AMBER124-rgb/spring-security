package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Role;
import com.app.pojos.userRole;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByRole(userRole role); 
}
