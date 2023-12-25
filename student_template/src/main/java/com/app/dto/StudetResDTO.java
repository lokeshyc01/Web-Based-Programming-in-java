package com.app.dto;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.app.entities.Course;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class StudetResDTO {
	
	private String firstName;
	private String lastName;
	private String email;
	private String courseTitle;
	private int marksScored;
	private Course course;
}
