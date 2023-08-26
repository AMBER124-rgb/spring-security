package com.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Role;
import com.app.pojos.UserEntity;
import com.app.pojos.userRole;

@SpringBootTest
public class ServiceLayerTests {

	@Autowired
	private IUserService userService;
	
	@Test
	void testSaveUser() 
	{
		UserEntity transientUser = new UserEntity("Rama", "rama@gmail.com","12345");
		UserEntity persistentUser = userService.saveUser(transientUser);
		System.out.println();
		assertEquals(1,persistentUser.getId());
	}
	
	@Test
	void testAddCustomerRole() 
	{
		Role role1 = userService.addRole(new Role(userRole.ROLE_CUSTOMER));
		System.out.println(role1);
	}
	
	@Test
	void testAddAdminRole() 
	{
		Role role2 = userService.addRole(new Role(userRole.ROLE_ADMIN));
		System.out.println(role2);
	}
	
	@Test
	void testLinkUserRole()
	{
		//add admin role to rama
		userService.linkUserRole("Rama",userRole.ROLE_ADMIN);
	}
}
