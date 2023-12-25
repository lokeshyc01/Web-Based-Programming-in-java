package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "course")
@Getter
@Setter
public class Course extends BaseEntity{
	
	@Column(name="course_title" , length=20,unique = true)
	private String courseTitle;
	@Column(name="start_date",nullable = false)
	private LocalDate startDate;
	@Column(name="end_date",nullable = false)
	private LocalDate endDate;
	@Column(nullable = false)
	private int fees;
	@Column(name="min_score",nullable = false)
	private int minScore;
}
