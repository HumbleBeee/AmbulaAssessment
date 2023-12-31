package com.example.AmbulaASSESSMENT.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "user_location")
public class UserLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "excluded")
	private boolean excluded;
	
	public UserLocation() {
		// TODO Auto-generated constructor stub
	}

	public UserLocation(String name, double latitude, double longitude, boolean excluded) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.excluded = excluded;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public boolean isExcluded() {
		return excluded;
	}

	public void setExcluded(boolean excluded) {
		this.excluded = excluded;
	}

	@Override
	public String toString() {
		return "UserLocation [id=" + id + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", excluded=" + excluded + "]";
	}
	
}
