package com.kunal.restaurant.Configuration;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kunal.restaurant.Services.UserDBService;

import jakarta.annotation.PostConstruct;

@Component
public class CacheInitializerConfig {

	@Autowired
	private UserDBService userDBService;

	@PostConstruct
	public void cacheUserDetailsOnStartup() {
		try {
			userDBService.fetchAllUserDetails();
			System.out.println("Successfully cached UserDetails on application startup!!");
		} catch (SQLException e) {
			System.out.println("Unable to fetch UserDetails on application startup!!");
			e.printStackTrace();
		}
	}

}
