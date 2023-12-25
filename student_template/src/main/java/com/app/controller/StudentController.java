package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseReqDTO;
import com.app.dto.StudentReqDTO;
import com.app.service.CourseService;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController 
{
	@Autowired
	public StudentService studentService;
	
	@PostMapping
	public ResponseEntity<?> launchCourse(@RequestBody StudentReqDTO student)
	{
		return ResponseEntity.ok().body(studentService.takeAdmission(student));
	}
	
	@GetMapping("/{course}")
	public ResponseEntity<?> getAllStudent(@PathVariable String course)
	{
		return ResponseEntity.ok().body(studentService.getStudentList(course));
	}
}
