package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Railway;
import com.app.entities.TrainCategory;
@Repository
public interface RailwayDao extends JpaRepository<Railway, Long>
{
	Optional<Railway> findByCategory(TrainCategory category);
	Optional<Railway> findByName(String trainName);
}
