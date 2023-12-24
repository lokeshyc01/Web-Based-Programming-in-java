package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.RailwayResDTO;
import com.app.service.RailwayService;

@RestController
@RequestMapping("/railways")
public class RailwayController {

	@Autowired
	private RailwayService railwayService;
	@Autowired
	private ModelMapper mapper;

	@PostMapping("/addrailway")
	public ResponseEntity<?> addRailway(@RequestBody RailwayResDTO railway) {
		System.out.println("endpoint hit");
		try {
			return ResponseEntity.status(HttpStatus.OK).body(railwayService.addRailway(railway));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}

	@DeleteMapping("/{railId}")
	public ResponseEntity<?> deleteRailway(@RequestParam Long railId) {
		try {
			return ResponseEntity.ok().body(railwayService.deleteRailway(railId));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}
	}
	
	@GetMapping
	public ResponseEntity<?> getRailway(@RequestParam String category)
	{
		try
		{
			return ResponseEntity.ok().body(railwayService.getTrain(category));
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body(new ApiResponse("could not get Railway"));
		}
	}
}
