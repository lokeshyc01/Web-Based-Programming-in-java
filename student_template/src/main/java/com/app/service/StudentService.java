package com.app.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.app.dto.StudentReqDTO;
import com.app.dto.StudetResDTO;

public interface StudentService {
	StudetResDTO takeAdmission(StudentReqDTO student);
	List<StudetResDTO> getStudentList(String courseName);
}
