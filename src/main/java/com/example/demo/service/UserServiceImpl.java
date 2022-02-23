package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.serDetailsImpl.UserDetailImpl;

@Service
public class UserServiceImpl implements UserDetailsService{
    
	@Autowired
	private UserRepository rep;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  User user = rep.findByUsername(username);
		  
		  if(user==null) 
			  throw new UsernameNotFoundException("404 not found");
		 // System.out.println("login");
		return new UserDetailImpl(user);
	}

}
