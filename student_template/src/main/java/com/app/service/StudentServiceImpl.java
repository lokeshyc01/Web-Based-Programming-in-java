package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.ResourceNotFound;
import com.app.dao.CourseDao;
import com.app.dao.StudentDao;
import com.app.dto.StudentReqDTO;
import com.app.dto.StudetResDTO;
import com.app.entities.Course;
import com.app.entities.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	@Autowired
	public StudentDao studentDao;
	@Autowired
	public ModelMapper mapper;
	@Autowired
	public CourseDao courseDao;
	
	@Override
	public StudetResDTO takeAdmission(StudentReqDTO student) {
		
		Student validStudent = mapper.map(student, Student.class);
		Course course = courseDao.findByCourseTitle(validStudent.getCourseTitle()).
				orElseThrow(()->new ResourceNotFound("Course Not Exist"));
		
		validStudent.setCourse(course);
		return mapper.map(studentDao.save(validStudent),StudetResDTO.class);
		
	}
	
	public List<StudetResDTO> getStudentList(String courseName)
	{
		
		Course course = courseDao.findByCourseTitle(courseName).orElseThrow(()->new ResourceNotFound("student not found"));
		List<Student> list = studentDao.findAllById(course.getId());
		
		return list.stream().map(s -> mapper.map(s, StudetResDTO.class)).collect(Collectors.toList());
//	return null;
	}

}
 