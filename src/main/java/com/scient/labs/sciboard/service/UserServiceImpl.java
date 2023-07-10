package com.scient.labs.sciboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.scient.labs.sciboard.dto.LoginRequest;
import com.scient.labs.sciboard.dto.UserDto;
import com.scient.labs.sciboard.exception.InvalidUserException;
import com.scient.labs.sciboard.model.User;
import com.scient.labs.sciboard.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public UserDto doLogin(LoginRequest request) throws InvalidUserException {
		UserDto dto = new UserDto();
		final Optional<User> userobj = userRepo.findByEmail(request.getUsername());
		if(!userobj.isPresent()) {
			throw new InvalidUserException("Invalid Login");
		}
		User user = userobj.get();
		if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			dto = new UserDto(user.getUsername(), user.getEmail(), user.getRole(), user.getImage());
		} else {
			throw new InvalidUserException("Invalid Login");
		}
		return dto;
	}

	@Override
	public Boolean addUser(LoginRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());
		user.setStatus("active");
		user.setImage(request.getImageUrl());
		userRepo.save(user);
		return true;
	}

}
