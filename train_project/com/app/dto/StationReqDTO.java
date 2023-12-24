package com.app.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.entities.Railway;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StationReqDTO {
	@NotBlank
	private String railname;
	@NotBlank
	private String stationCode;
	@NotBlank
	private String stationName;
	@NotNull
	private int platformCount;
	
}
