package com.howtodoinjava.demo.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.manager.EmployeeManager;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {

	@Autowired
	private EmployeeManager employeeManager;

	@GetMapping(value = "emp")
	public ResponseEntity<?> routeController(HttpServletRequest request) {
		LocalDateTime start = LocalDateTime.now();
		try {
			Map<String, String> map = employeeManager.testOmegaCache(request.getQueryString());
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		} finally {
			log.info("Total Time:" + Duration.between(start, LocalDateTime.now()));
		}
	}

}
