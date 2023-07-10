package com.scient.labs.sciboard.model;

import java.time.ZonedDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "room_temperature")
public class RoomTemperature {
	private String device;
	private Integer humidity;
	@Field("temperature_f")
	private Long temperatureF;
	@Field("temperature_c")
	private Long temperatureC;
	@Field("timestamp")
	private ZonedDateTime timestamp;

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Long getTemperatureF() {
		return temperatureF;
	}

	public void setTemperatureF(Long temperatureF) {
		this.temperatureF = temperatureF;
	}

	public Long getTemperatureC() {
		return temperatureC;
	}

	public void setTemperatureC(Long temperatureC) {
		this.temperatureC = temperatureC;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
