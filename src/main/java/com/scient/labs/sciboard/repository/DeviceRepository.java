package com.scient.labs.sciboard.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.scient.labs.sciboard.model.Device;

public interface DeviceRepository  extends MongoRepository<Device, String>{

	public Optional<Device> findByNameAndLocation(String name, String location);
	
}
