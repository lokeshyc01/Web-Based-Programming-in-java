package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dto.CourseReqDTO;
import com.app.dto.CourseResDTO;
import com.app.entities.Course;

@Service
@Transactional
public class CourseServiceImple implements CourseService{
	@Autowired
	public CourseDao courseDao;
	@Autowired
	public ModelMapper mapper;
	@Override
	public CourseResDTO addCourse(CourseReqDTO course) {
		
		Course validCourse = mapper.map(course, Course.class);
		return mapper.map(courseDao.save(validCourse), CourseResDTO.class);
	}
	
}
