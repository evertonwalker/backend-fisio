package com.fisio.fisio.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fisio.fisio.model.Schedule;

public interface ScheduleJpaRepository  extends JpaRepository<Schedule, Long>{

    @Query(value = "SELECT s FROM Schedule as s WHERE s.startDate between :startDate and :endDate")
    Schedule findBetweenRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
}
