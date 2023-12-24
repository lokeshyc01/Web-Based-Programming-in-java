package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customexception.ResourceNotFound;
import com.app.dao.RailwayDao;
import com.app.dto.RailwayResDTO;
import com.app.entities.Railway;
import com.app.entities.TrainCategory;
@Service
@Transactional
public class RaiwayServiceImpl implements RailwayService{
	
	@Autowired
	private RailwayDao railDao; 
	@Autowired
	private ModelMapper mapper;
	
	public RailwayResDTO addRailway(RailwayResDTO railway)
	{
		 Railway response = railDao.save(mapper.map(railway, Railway.class));
		 return mapper.map(response, RailwayResDTO.class);
	}

	
	public String deleteRailway(Long id){
		if(railDao.existsById(id))
		{
			railDao.deleteById(id);
			return "Railway Deleted";
		}
		throw new ResourceNotFound("Railway not exist with given id");
	}
	
	public RailwayResDTO getTrain(String category)
	{
		Railway rail = railDao.findByCategory(TrainCategory.valueOf(category))
				.orElseThrow(()->new ResourceNotFound("Train not exist"));
		 
		return mapper.map(rail, RailwayResDTO.class);
	}
}
