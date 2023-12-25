package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student extends BaseEntity{
	
	@Column(name="first_name" , length=20,unique = true)
	private String firstName;
	@Column(name="last_name",length=20)
	private String lastName;
	@Column(unique = true)
	private String email;
	@Column(name="course_title")
	private String courseTitle;
	@Column(nullable = false,name="marks_scored")
	private int marksScored;
	@ManyToOne
	private Course course;
	
	
	public void setCourseDetails(Course course)
	{
		this.course = course;
	}
}
