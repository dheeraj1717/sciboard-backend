package com.scient.labs.sciboard.service;

import java.util.List;

import com.scient.labs.sciboard.dto.LoginRequest;
import com.scient.labs.sciboard.dto.UserDto;
import com.scient.labs.sciboard.exception.InvalidUserException;
import com.scient.labs.sciboard.model.User;

public interface UserService {
	public List<User> getUsers();

	public Boolean addUser(LoginRequest request);
	
	public UserDto doLogin(LoginRequest request) throws InvalidUserException;
}
