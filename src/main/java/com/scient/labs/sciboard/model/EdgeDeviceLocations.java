package com.scient.labs.sciboard.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "edge_devices_locations")
public class EdgeDeviceLocations {
	@Id
	private Integer id;
	@Field("device_name")
	private String deviceName;
	@Field("device_location_id")
	private Integer deviceLocationId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Integer getDeviceLocationId() {
		return deviceLocationId;
	}

	public void setDeviceLocationId(Integer deviceLocationId) {
		this.deviceLocationId = deviceLocationId;
	}

}
