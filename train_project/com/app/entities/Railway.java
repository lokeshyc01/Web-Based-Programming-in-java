package com.app.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name="railway")
public class Railway extends BaseEntity
{
	@Column(length = 20)
	private String name;
	@Enumerated(EnumType.STRING)
	private TrainCategory category;
	@Column(name = "start_time",nullable = false)
	private LocalDateTime startTime;
	@Column(name = "end_time",nullable = false)
	private LocalDateTime endTime;
	@Column(length = 20)
	private String source;
	@Column(length = 20)
	private String destination;
	@OneToMany(mappedBy = "railway",cascade = CascadeType.ALL)
	private List<Stations> stations = new ArrayList<>();
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(TrainCategory category) {
		this.category = category;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setStations(Stations stations) {
		this.stations.add(stations);
		stations.setRailway(this);
	}
	
	
}
