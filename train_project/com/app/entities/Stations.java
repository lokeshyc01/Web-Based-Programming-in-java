package com.app.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "stations")
public class Stations extends BaseEntity
{
	@Column(name="station_code",length=20)
	private String stationCode;
	@Column(name="station_name",length=20)
	private String stationName;
	@Column(name="platform_count")
	private int platformCount;
	
	@ManyToOne
	private Railway railway;
}
