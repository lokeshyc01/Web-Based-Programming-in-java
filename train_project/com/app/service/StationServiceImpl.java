package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.ResourceNotFound;
import com.app.dao.RailwayDao;
import com.app.dao.StationDao;
import com.app.dto.StationReqDTO;
import com.app.dto.StationResDTO;
import com.app.entities.Railway;
import com.app.entities.Stations;
@Service
@Transactional
public class StationServiceImpl implements StationService
{
	@Autowired
	private StationDao stationDao;
	@Autowired
	private RailwayDao railDao;
	@Autowired
	private ModelMapper mapper;
	
	public StationResDTO addStation(StationReqDTO station)
	{
		Railway train = railDao.findByName(station.getRailname()).orElseThrow(()->new ResourceNotFound("Train not exist : cannot add station"));
		
		Stations stations = mapper.map(station, Stations.class);
		
		train.setStations(stations);
		return mapper.map(stations, StationResDTO.class);
	}
}
