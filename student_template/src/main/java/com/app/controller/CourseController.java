package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
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
	
	@PutMapping("/{id}/fees/{amount}")
	public ResponseEntity<?> updateCourseFees(@PathVariable Long id,@PathVariable int amount)
	{
		return ResponseEntity.ok().body(courseService.updateCourse(id, amount));
	}
	
	@DeleteMapping("/{courseid}/students/{studentid}")
	public ResponseEntity<?> cancelAdmission(@PathVariable Long courseid,@PathVariable Long studentid)
	{
		return ResponseEntity.ok().body(new ApiResponse(courseService.cancelAdmission(courseid, studentid)));
	}
}
