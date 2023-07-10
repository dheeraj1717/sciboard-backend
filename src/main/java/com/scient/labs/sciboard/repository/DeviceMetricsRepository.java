package com.scient.labs.sciboard.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.scient.labs.sciboard.model.DeviceMetrics;

@Repository
public interface DeviceMetricsRepository extends MongoRepository<DeviceMetrics, ObjectId>{
	
	public List<DeviceMetrics> findByLocation(String location);
	
	public DeviceMetrics findFirstByLocationOrderByTimestampDesc(String location);
	
	public List<DeviceMetrics> findByTimestampBetweenAndLocation(ZonedDateTime startTimestamp, ZonedDateTime endTimestamp, String location);

}
