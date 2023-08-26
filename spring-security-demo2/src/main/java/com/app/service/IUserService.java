package com.app.service;

import com.app.pojos.Role;
import com.app.pojos.UserEntity;
import com.app.pojos.userRole;

public interface IUserService {
	UserEntity saveUser(UserEntity user);
	Role addRole(Role role);
	String linkUserRole(String userName,userRole roleName);
}
