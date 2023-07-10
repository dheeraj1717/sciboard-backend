package com.scient.labs.sciboard.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.scient.labs.sciboard.model.RoomTemperature;

public interface RoomTemperatureRepository extends MongoRepository<RoomTemperature, ObjectId>{
	public RoomTemperature findFirstByDeviceOrderByTimestampDesc(String device);
	
	public List<RoomTemperature> findByTimestampBetweenAndDevice(ZonedDateTime startTimestamp, ZonedDateTime endTimestamp, String device);
	public List<RoomTemperature> findByTimestampBetween(ZonedDateTime startTimestamp, ZonedDateTime endTimestamp);
}
