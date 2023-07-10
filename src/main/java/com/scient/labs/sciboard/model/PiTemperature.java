package com.scient.labs.sciboard.model;

import java.sql.Timestamp;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "pitemperature")
public class PiTemperature {
	private String device;
	@Field("temp_c")
	private String tempC;
	private Timestamp time;

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getTempC() {
		return tempC;
	}

	public void setTempC(String tempC) {
		this.tempC = tempC;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}
