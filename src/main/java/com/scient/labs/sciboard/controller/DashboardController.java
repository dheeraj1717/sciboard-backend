package com.scient.labs.sciboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scient.labs.sciboard.dto.DeviceStats;
import com.scient.labs.sciboard.dto.MetricRequest;
import com.scient.labs.sciboard.dto.MetricRes;
import com.scient.labs.sciboard.model.Device;
import com.scient.labs.sciboard.service.DashboardService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/devices")
	public List<Device> getDevices() {
		return dashboardService.getDevices();
	}

	@GetMapping("/stats")
	public DeviceStats getDeviceStatus(@RequestParam String device, @RequestParam String location) {
		return dashboardService.getDeviceStats(device, location);
	}

	@PostMapping("/metrics")
	public List<MetricRes> getDeviceMetrics(@RequestBody MetricRequest request) {
		return dashboardService.getMetricsData(request);
	}
	
	@PostMapping("/envmetrics")
	public List<MetricRes> getDeviceRoomTempMetrics(@RequestBody MetricRequest request) {
		return dashboardService.getRoomTempMetricsData(request);
	}
}
