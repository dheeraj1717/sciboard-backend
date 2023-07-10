package com.scient.labs.sciboard.service;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scient.labs.sciboard.dto.DeviceStats;
import com.scient.labs.sciboard.dto.MetricRequest;
import com.scient.labs.sciboard.dto.MetricRes;
import com.scient.labs.sciboard.model.Device;
import com.scient.labs.sciboard.model.DeviceMetrics;
import com.scient.labs.sciboard.model.RoomTemperature;
import com.scient.labs.sciboard.repository.DeviceMetricsRepository;
import com.scient.labs.sciboard.repository.DeviceRepository;
import com.scient.labs.sciboard.repository.RoomTemperatureRepository;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private DeviceMetricsRepository deviceMetricsRepo;

	@Autowired
	private DeviceRepository deviceRepo;

	@Autowired
	private RoomTemperatureRepository roomTemperatureRepo;

	@Override
	public List<MetricRes> getMetricsData(MetricRequest request) {
		List<DeviceMetrics> metList = deviceMetricsRepo.findByTimestampBetweenAndLocation(ZonedDateTime.parse(request.getStartDate()), ZonedDateTime.parse(request.getEndDate()), request.getLocation());
		return MetricRes.buildList(metList, null);
	}

	@Override
	public List<MetricRes> getRoomTempMetricsData(MetricRequest request) {
		List<RoomTemperature> tempList = roomTemperatureRepo.findByTimestampBetween(ZonedDateTime.parse(request.getStartDate()), ZonedDateTime.parse(request.getEndDate()));
		return MetricRes.buildList(null, tempList);
	}

	@Override
	public DeviceStats getDeviceStats(String device, String location) {
		final DeviceMetrics metric = deviceMetricsRepo.findFirstByLocationOrderByTimestampDesc(location);
		final RoomTemperature roomTemp = roomTemperatureRepo.findFirstByDeviceOrderByTimestampDesc(device);
		final DeviceStats stats = new DeviceStats();
		if (metric != null) {
			stats.setCpuUsage(metric.getCpuUsage());
			stats.setMemoryUsage(metric.getMemoryUsage());
			stats.setTemperatureC(metric.getTemperatureC());
		}

		if (roomTemp != null) {
			stats.setRoomHumidity(roomTemp.getHumidity());
			stats.setRoomTemperatureC(roomTemp.getTemperatureC());
			stats.setRoomTemperatureF(roomTemp.getTemperatureF());
		}

		return stats;
	}

	public List<Device> getDevices() {
		return deviceRepo.findAll();
	}

}
