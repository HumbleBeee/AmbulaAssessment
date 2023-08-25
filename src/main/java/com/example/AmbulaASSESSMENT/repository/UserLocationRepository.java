package com.example.AmbulaASSESSMENT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AmbulaASSESSMENT.entity.UserLocation;

@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Integer> {

}
