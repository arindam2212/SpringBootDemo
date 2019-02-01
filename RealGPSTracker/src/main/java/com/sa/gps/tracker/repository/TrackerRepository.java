package com.sa.gps.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa.gps.tracker.entity.GPSDataEntity;

public interface TrackerRepository extends JpaRepository<GPSDataEntity, Long> {
	
	public List<GPSDataEntity> findByregId(long regId);


}
