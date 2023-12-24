package com.app.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.entities.Stations;
import com.app.entities.TrainCategory;

public class RailwayReqDTO {
	@NotBlank
	private String railName;
	@NotNull
	private TrainCategory category;
	@NotBlank
	private String startTime;
	@NotBlank
	private String endTime;
	@NotBlank
	private String source;
	@NotBlank
	private String destination;
	private List<Stations> stations;
	
	
}
