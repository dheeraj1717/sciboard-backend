package com.scient.labs.sciboard.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scient.labs.sciboard.dto.LoginRequest;
import com.scient.labs.sciboard.dto.UserDto;
import com.scient.labs.sciboard.exception.InvalidUserException;
import com.scient.labs.sciboard.model.User;
import com.scient.labs.sciboard.security.AuthRequest;
import com.scient.labs.sciboard.security.AuthResponse;
import com.scient.labs.sciboard.security.JwtUtil;
import com.scient.labs.sciboard.service.UserService;

import io.jsonwebtoken.security.InvalidKeyException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	AuthenticationManager authManager;
	@Autowired
	JwtUtil jwtUtil;

	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			Authentication authentication = authManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

			User user = (User) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			AuthResponse response = new AuthResponse();
			response.setAccessToken(accessToken);
			response.setUsername(user.getUsername());
			response.setEmail(user.getEmail());
			response.setImage(user.getImage());
			response.setRole(user.getRole());
			response.setStatus(user.getStatus());

			return ResponseEntity.ok().body(response);

		} catch (BadCredentialsException | InvalidKeyException | NoSuchAlgorithmException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping("/login")
	public ResponseEntity<UserDto> doLogin(@RequestBody LoginRequest request) {
		UserDto dto = null;
		try {
			dto = userService.doLogin(request);
		} catch (InvalidUserException e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(dto);
	}

	@PutMapping("/user")
	public Boolean addUser(@RequestBody LoginRequest request) {
		return userService.addUser(request);
	}

}
