package com.example.AmbulaASSESSMENT.service;

import java.util.List;

import com.example.AmbulaASSESSMENT.entity.UserLocation;

public interface UserLocationService {

	public UserLocation createLocation(UserLocation theUSerLocation);
	public List<UserLocation> getNearestLocation(int n);
}
