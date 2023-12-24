package com.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StationReqDTO;
import com.app.service.StationService;
import com.app.dto.ApiResponse;

@RestController
@RequestMapping("/station")
public class StationController {
	
	@Autowired
	private StationService stationService;
	@PostMapping
	public ResponseEntity<?> addStation(@RequestBody StationReqDTO station)
	{
		try
		{
			return ResponseEntity.ok().body(stationService.addStation(station));
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

}
