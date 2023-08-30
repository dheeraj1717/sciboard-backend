package com.scient.labs.sciboard.service;

import java.util.List;

import com.scient.labs.sciboard.dto.DeviceRequest;
import com.scient.labs.sciboard.dto.DeviceStats;
import com.scient.labs.sciboard.dto.MetricRequest;
import com.scient.labs.sciboard.dto.MetricRes;
import com.scient.labs.sciboard.model.Device;

public interface DashboardService {
	
	public List<MetricRes> getMetricsData(MetricRequest request);
	
	public List<MetricRes> getRoomTempMetricsData(MetricRequest request);
	
	public DeviceStats getDeviceStats(String device, String location);
	
	public List<Device> getDevices();
	
	public void updateDeviceStatus(DeviceRequest request);
}
