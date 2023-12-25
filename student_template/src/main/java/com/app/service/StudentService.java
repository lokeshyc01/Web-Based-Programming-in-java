package com.app.service;

import com.app.dto.StudentReqDTO;
import com.app.dto.StudetResDTO;

public interface StudentService {
	StudetResDTO takeAdmission(StudentReqDTO student);
}
