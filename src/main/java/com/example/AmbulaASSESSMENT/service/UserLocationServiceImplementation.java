package com.example.AmbulaASSESSMENT.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AmbulaASSESSMENT.entity.UserLocation;
import com.example.AmbulaASSESSMENT.repository.UserLocationRepository;

@Service
public class UserLocationServiceImplementation implements UserLocationService {

	UserLocationRepository userLocation;
	
	@Autowired
	public UserLocationServiceImplementation(UserLocationRepository userLocation) {
		super();
		this.userLocation = userLocation;
	}

	@Override
	public UserLocation createLocation(UserLocation theUSerLocation) {
		// TODO Auto-generated method stub
		return userLocation.save(theUSerLocation);
	}

	@Override
	public List<UserLocation> getNearestLocation(int n) {
		// TODO Auto-generated method stub
		List<UserLocation> allUsers = userLocation.findAll();
		List<UserLocation> nearestUsers = new ArrayList<>();
		
		//Sort the users by distance from (0,0)
		Collections.sort(allUsers, new Comparator<UserLocation>() {
			@Override
			public int compare(UserLocation u1, UserLocation u2) {
				double distance1 = calculateDistance(u1.getLatitude(), u1.getLongitude(), 0, 0);
				double distance2 = calculateDistance(u2.getLatitude(), u2.getLongitude(), 0, 0);
				return Double.compare(distance1, distance2);
			}
		});
		
		// Add the nearest 'n' users to the result list
		for(UserLocation user : allUsers) {
			if(!user.isExcluded()) {
				nearestUsers.add(user);
				if(nearestUsers.size() == n) {
					break;
				}
			}
		}
		return nearestUsers;
	}
	
	private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		double R = 6371; // Earth's radius in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;
        return distance;
	}
	
}
