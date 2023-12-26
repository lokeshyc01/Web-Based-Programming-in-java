package com.app.service;

import com.app.dto.CourseReqDTO;
import com.app.dto.CourseResDTO;

public interface CourseService 
{
	CourseResDTO addCourse(CourseReqDTO course);
	String updateCourse(Long id,int amount);
	String cancelAdmission(Long courseid,Long studentid);
}
