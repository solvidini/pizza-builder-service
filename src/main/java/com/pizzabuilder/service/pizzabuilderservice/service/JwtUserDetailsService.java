package com.pizzabuilder.service.pizzabuilderservice.service;

import com.pizzabuilder.service.pizzabuilderservice.config.JwtTokenUtil;
import com.pizzabuilder.service.pizzabuilderservice.model.JwtResponse;
import com.pizzabuilder.service.pizzabuilderservice.model.UserDao;
import com.pizzabuilder.service.pizzabuilderservice.model.UserDto;
import com.pizzabuilder.service.pizzabuilderservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDao user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public JwtResponse save(UserDto user) {
		UserDao newUser = new UserDao();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		userDao.save(newUser);
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		final String username = jwtTokenUtil.getUsernameFromToken(token);
		final Date date = jwtTokenUtil.getExpirationDateFromToken(token);

		return new JwtResponse(token, username, date);
	}
}