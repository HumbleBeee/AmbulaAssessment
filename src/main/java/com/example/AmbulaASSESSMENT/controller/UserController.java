package com.example.AmbulaASSESSMENT.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AmbulaASSESSMENT.entity.UserLocation;
import com.example.AmbulaASSESSMENT.service.UserLocationService;

@RestController
@RequestMapping("/user")
public class UserController {

	UserLocationService userLocation;

	@Autowired
	public UserController(UserLocationService userLocation) {
		super();
		this.userLocation = userLocation;
	}
	
	@PostMapping("/create_data")
	public UserLocation saveUser(@RequestBody UserLocation theUser, @RequestHeader("role") String role) throws AccessDeniedException {
		if(role.equals("ADMIN")) {
			return userLocation.createLocation(theUser);
		} else {
			throw new AccessDeniedException("Access denied");
		}
	}
	
	@PutMapping("/update_data")
	public UserLocation updateUser(@RequestBody UserLocation theUser, @RequestHeader("role") String role) throws AccessDeniedException{
		if(role.equals("ADMIN")) {
			return userLocation.createLocation(theUser);
		} else {
			throw new AccessDeniedException("Access denied");
		}
	}
	
	@GetMapping("/get_users/{n}")
	public List<UserLocation> getNearestUsers(@PathVariable int n, @RequestHeader("role") String role) throws AccessDeniedException{
		if(role.equals("ADMIN") || role.equals("READER")) {
			return userLocation.getNearestLocation(n);
		} else {
			throw new AccessDeniedException("Access denied");
		}
	}
	
	
}
