package com.scient.labs.sciboard.model;

import java.time.ZonedDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "device_metrics")
public class DeviceMetrics {
	 @Field("timestamp")
	private ZonedDateTime timestamp;
	@Field("temperature_c")
	private Long temperatureC;
	@Field("cpu_usage")
	private Float cpuUsage;
	@Field("memory_usage")
	private Float memoryUsage;
	private String device;
	private String region;
	private String location;
	private Double latitude;
	private Double longitude;

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Long getTemperatureC() {
		return temperatureC;
	}

	public void setTemperatureC(Long temperatureC) {
		this.temperatureC = temperatureC;
	}

	public Float getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(Float cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public Float getMemoryUsage() {
		return memoryUsage;
	}

	public void setMemoryUsage(Float memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
