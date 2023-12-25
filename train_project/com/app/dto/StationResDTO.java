package com.app.dto;
import com.app.entities.Railway;
@Getter
@Setter
public class StationResDTO {
	
	private String stationCode;
	private String stationName;
	private int platformCount;
	private Railway railway;
}
