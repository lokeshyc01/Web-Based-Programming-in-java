package com.app.service;

import com.app.dto.RailwayResDTO;
import com.app.entities.Railway;

public interface RailwayService {
	RailwayResDTO addRailway(RailwayResDTO railway);
	String deleteRailway(Long id);
	RailwayResDTO getTrain(String category);
}
