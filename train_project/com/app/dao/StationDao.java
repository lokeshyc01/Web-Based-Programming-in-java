package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Stations;

public interface StationDao extends JpaRepository<Stations, Long>{
	
	
}
