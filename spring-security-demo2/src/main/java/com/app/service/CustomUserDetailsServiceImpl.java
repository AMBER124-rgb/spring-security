package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.pojos.UserEntity;

@Service
@Transactional
public class CustomUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// invoke dao's method to get user details
		UserEntity user= userRepo.findByUserName(username).orElseThrow(()->new UsernameNotFoundException(username));	
		//user detials found
		
		return new CustomUserDetails(user);
	}

}
