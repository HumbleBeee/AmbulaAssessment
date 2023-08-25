package com.example.AmbulaASSESSMENT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.AmbulaASSESSMENT.entity.UserLocation;
import com.example.AmbulaASSESSMENT.repository.UserLocationRepository;
import com.example.AmbulaASSESSMENT.service.UserLocationService;
import com.example.AmbulaASSESSMENT.service.UserLocationServiceImplementation;

@SpringBootTest
class AmbulaAssessmentApplicationTests {

	@Mock
	UserLocationRepository locationRepo;
	
	@InjectMocks
	UserLocationService locationService = new UserLocationServiceImplementation(locationRepo);
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testSaveUser() {
		//Arrange
		UserLocation location = new UserLocation("Location 1", 10.0, 20.0, false);
		when(locationRepo.save(location)).thenReturn(location);
		
		// Act
        UserLocation updatedCoordinates = locationService.createLocation(location);

        // Assert
        assertEquals(location, updatedCoordinates);
	}
	
	public void testNearestUser() {
		//Arrange
		int n = 2;
        List<UserLocation> allCoordinates = new ArrayList<>();
        allCoordinates.add(new UserLocation("Location 1", 10.0, 20.0, false));
        allCoordinates.add(new UserLocation("Location 2", 30.0, 40.0, false));
        allCoordinates.add(new UserLocation("Location 3", 50.0, 60.0, false));
        allCoordinates.add(new UserLocation("Location 4", 70.0, 80.0, false));
        allCoordinates.add(new UserLocation("Location 3", 85.0, 90.0, false));
        when(locationRepo.findAll()).thenReturn(allCoordinates);

        // Act
        List<UserLocation> nearestCoordinates = locationService.getNearestLocation(n);

        // Assert
        assertEquals(n, nearestCoordinates.size());
        assertEquals("Location 1", nearestCoordinates.get(0).getName());
        assertEquals("Location 2", nearestCoordinates.get(1).getName());
        // Add additional assertions for the expected nearest coordinates
		
	}

}
