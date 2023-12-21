package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Todo;

public interface TodoDao extends JpaRepository<Todo, Long>{

}
