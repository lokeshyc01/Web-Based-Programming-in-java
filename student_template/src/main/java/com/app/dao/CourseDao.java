package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>
{
	Optional<Course> findByCourseTitle(String course);
}
