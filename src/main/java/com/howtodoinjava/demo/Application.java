package com.howtodoinjava.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//https://www.ehcache.org/documentation/2.8/replication/rmi-replicated-caching.html#configuring-the-peer-provider
@SpringBootApplication
@EnableCaching
public class Application {
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	 
}
