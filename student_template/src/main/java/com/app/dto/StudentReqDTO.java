package com.app.dto;

import com.app.entities.Course;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class StudentReqDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String courseTitle;
	private int marksScored;
}
