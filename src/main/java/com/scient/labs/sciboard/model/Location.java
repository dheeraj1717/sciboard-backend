package com.scient.labs.sciboard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "locations_data")
public class Location {
	@Id
	private Integer id;

	@Field("parent_location")
	private String parentLocation;
	private String location;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParentLocation() {
		return parentLocation;
	}

	public void setParentLocation(String parentLocation) {
		this.parentLocation = parentLocation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
