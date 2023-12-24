package com.app.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.app.entities.Stations;
import com.app.entities.TrainCategory;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RailwayResDTO {
	@NotBlank
	private String name;
	@NotNull
	private TrainCategory category;
	@NotNull
	@PastOrPresent
	private LocalDateTime startTime;
	@Future
	private LocalDateTime endTime;
	@NotBlank
	private String source;
	@NotBlank
	private String destination;
	
	
	
}
