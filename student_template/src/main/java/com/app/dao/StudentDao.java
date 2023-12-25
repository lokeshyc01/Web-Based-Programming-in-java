package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Student;

public interface StudentDao extends JpaRepository<Student, Long>{
	@Query("select s from Student s where s.course.Id = ?1")
	List<Student> findAllById(Long id);
}
