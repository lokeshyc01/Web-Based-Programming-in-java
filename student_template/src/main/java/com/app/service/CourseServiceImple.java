package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.ResourceNotFound;
import com.app.dao.CourseDao;
import com.app.dao.StudentDao;
import com.app.dto.CourseReqDTO;
import com.app.dto.CourseResDTO;
import com.app.entities.Course;
import com.app.entities.Student;

@Service
@Transactional
public class CourseServiceImple implements CourseService{
	@Autowired
	public CourseDao courseDao;
	@Autowired
	public ModelMapper mapper;
	@Autowired
	public StudentDao studentDao;
	
	@Override
	public CourseResDTO addCourse(CourseReqDTO course) {
		
		Course validCourse = mapper.map(course, Course.class);
		return mapper.map(courseDao.save(validCourse), CourseResDTO.class);  
	}
	
	public String updateCourse(Long id,int amount) {
		Course course = courseDao.findById(id).orElseThrow(()->new ResourceNotFound("Could not find course!!!"));
		course.setFees(amount);
		return "fees updated successfullyy!!!";
	}

	public String cancelAdmission(Long courseid, Long studentid) {
		Student student = studentDao.findById(studentid).orElseThrow(()->new ResourceNotFound("Could not find course!!!"));
		
		student.setCourse(null);
		studentDao.delete(student);
		return "student admission got cancelled";
	}
	
}
