package dao;

import pojos.Course;
import pojos.Student;

interface StudentDao {
	String takeAdmission(Student student,String courseName);
}
