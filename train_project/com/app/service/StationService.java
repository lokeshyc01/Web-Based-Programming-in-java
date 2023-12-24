package com.app.service;
import com.app.dto.StationReqDTO;
import com.app.dto.StationResDTO;
import com.app.entities.Stations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationService{
	StationResDTO addStation(StationReqDTO station);
}
