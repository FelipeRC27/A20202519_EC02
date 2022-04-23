package com.example.demo.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if("Felipe".equals(username)) {
			return new User("Felipe", "123", new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("El usuario no existe");
		}				
	}

}
