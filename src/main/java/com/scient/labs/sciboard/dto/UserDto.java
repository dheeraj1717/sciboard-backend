package com.scient.labs.sciboard.dto;

public class UserDto {
	private String username;
	private String email;
	private String role;
	private String image;

	public UserDto(String username, String email, String role, String image) {
		super();
		this.username = username;
		this.email = email;
		this.role = role;
		this.image = image;
	}
	
	public UserDto() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
