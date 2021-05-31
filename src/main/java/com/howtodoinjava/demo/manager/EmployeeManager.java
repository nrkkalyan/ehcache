package com.howtodoinjava.demo.manager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.service.TracerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeManager {

	@Autowired
	private TracerService tracerService;
	@Autowired
	private Environment environment;

	@Cacheable(cacheNames = "employeeCache")
	public Map<String, String> testOmegaCache(String id) {
		log.info("*****************Employee from DB: " + id);
		final Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("application.name", environment.getProperty("spring.application.name"));
		map.put("port", environment.getProperty("server.port"));
		map.put("uuid", UUID.randomUUID().toString());
		map.put("logTraceId", tracerService.getTraceId());
		return Collections.unmodifiableMap(map);
	}


}