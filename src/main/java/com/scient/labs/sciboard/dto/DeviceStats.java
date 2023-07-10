package com.scient.labs.sciboard.dto;

public class DeviceStats {
	private Long temperatureC;
	private Float memoryUsage;
	private Float cpuUsage;
	private Long roomTemperatureF;
	private Long roomTemperatureC;
	private Integer roomHumidity;

	public Long getRoomTemperatureF() {
		return roomTemperatureF;
	}

	public void setRoomTemperatureF(Long roomTemperatureF) {
		this.roomTemperatureF = roomTemperatureF;
	}

	public Long getRoomTemperatureC() {
		return roomTemperatureC;
	}

	public void setRoomTemperatureC(Long roomTemperatureC) {
		this.roomTemperatureC = roomTemperatureC;
	}

	public Integer getRoomHumidity() {
		return roomHumidity;
	}

	public void setRoomHumidity(Integer roomHumidity) {
		this.roomHumidity = roomHumidity;
	}

	public Long getTemperatureC() {
		return temperatureC;
	}

	public void setTemperatureC(Long temperatureC) {
		this.temperatureC = temperatureC;
	}

	public Float getMemoryUsage() {
		return memoryUsage;
	}

	public void setMemoryUsage(Float memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	public Float getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(Float cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

}
