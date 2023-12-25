package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseReqDTO;
import com.app.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController 
{
	@Autowired
	public CourseService courseService;
	
	@PostMapping
	public ResponseEntity<?> launchCourse(@RequestBody CourseReqDTO course)
	{
		return ResponseEntity.ok().body(courseService.addCourse(course));
	}
}
