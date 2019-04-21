package com.fisio.fisio.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisio.fisio.exception.ScheduleInSamePeriodException;
import com.fisio.fisio.exception.ScheduleNotFoundException;
import com.fisio.fisio.model.Schedule;
import com.fisio.fisio.repository.ScheduleJpaRepository;

@Service
public class ScheduleService {

	@Autowired
	ScheduleJpaRepository scheduleJpaRepository;

	public Schedule create(Schedule schedule) {
		
		verifySamePeriod(schedule.getStartDate(), schedule.getEndDate());
		return scheduleJpaRepository.save(schedule);
	}

	public Schedule update(Schedule schedule, Long id) {

		Schedule scheduleFind = findById(id);
		verifySamePeriod(schedule.getStartDate(), schedule.getEndDate());
		scheduleFind.update(schedule);

		return scheduleJpaRepository.save(scheduleFind);
	}

	public List<Schedule> getAll() {
		return scheduleJpaRepository.findAll();
	}

	public Schedule findById(Long id) {

		Optional<Schedule> scheduleFind = scheduleJpaRepository.findById(id);
		if (scheduleFind.isEmpty()) {
			throw new ScheduleNotFoundException();
		}

		return scheduleFind.get();
	}

	private Boolean verifySamePeriod(Date startDate, Date endDate) {
		
		if(!scheduleJpaRepository.findBetweenRange(startDate, endDate).isEmpty()) {
			throw new ScheduleInSamePeriodException();
		}
		
		return false;
	}

	public void deleteSchedule(Long id) {
		scheduleJpaRepository.delete(findById(id));
	}

}
