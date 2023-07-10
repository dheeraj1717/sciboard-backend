package com.scient.labs.sciboard.dto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.scient.labs.sciboard.model.DeviceMetrics;
import com.scient.labs.sciboard.model.RoomTemperature;

public class MetricRes {
	private String timestamp;
	private Float cpuUsage;
	private Float memoryUsage;
	private String device;
	private String region;
	private String location;
	private Double latitude;
	private Double longitude;
	private Integer humidity;
	private Long temperatureF;
	private Long temperatureC;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
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

	public static List<MetricRes> buildList(List<DeviceMetrics> metList, List<RoomTemperature> tempList) {
		List<MetricRes> resList = new ArrayList<>();
		if (metList == null) {
			for (RoomTemperature met : tempList) {
				resList.add(build(met));
			}
		}

		if (tempList == null) {
			for (DeviceMetrics met : metList) {
				resList.add(build(met));
			}
		}
		return resList;
	}

	private static MetricRes build(DeviceMetrics met) {
		MetricRes res = new MetricRes();
		res.setCpuUsage(met.getCpuUsage());
		res.setMemoryUsage(met.getMemoryUsage());
		res.setTemperatureC(met.getTemperatureC());
		res.setTimestamp(getTimestamp(met.getTimestamp()));
		return res;
	}

	private static MetricRes build(RoomTemperature met) {
		MetricRes res = new MetricRes();
		res.setHumidity(met.getHumidity());
		res.setTemperatureC(met.getTemperatureC());
		res.setTemperatureF(met.getTemperatureF());
		res.setTimestamp(getTimestamp(met.getTimestamp()));
		return res;
	}

	private static String getTimestamp(ZonedDateTime timestamp) {
		return DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss").format(timestamp);
	}
}
