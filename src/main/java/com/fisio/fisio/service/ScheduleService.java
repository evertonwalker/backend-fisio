package com.fisio.fisio.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fisio.fisio.exception.ScheduleEndPeriodBiggerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisio.fisio.exception.ScheduleInSamePeriodException;
import com.fisio.fisio.exception.ScheduleNotFoundException;
import com.fisio.fisio.exception.ScheduleSameTimeException;
import com.fisio.fisio.model.Schedule;
import com.fisio.fisio.repository.ScheduleJpaRepository;

@Service
public class ScheduleService {

	@Autowired
	ScheduleJpaRepository scheduleJpaRepository;

	public Schedule create(Schedule schedule) {

		verifyPeriodLessThanOrSame(schedule.getStartDate(), schedule.getEndDate());

		if (verifySamePeriod(schedule.getStartDate(), schedule.getEndDate()) != null) {
			throw new ScheduleInSamePeriodException();
		}
		
		return scheduleJpaRepository.save(schedule);
	}

	public Schedule update(Schedule schedule, Long id) {

		Schedule scheduleFind = findById(id);

		verifyPeriodLessThanOrSame(schedule.getStartDate(), schedule.getEndDate());

		if (verifySamePeriod(schedule.getStartDate(), schedule.getEndDate()) != null
				&& verifySamePeriod(schedule.getStartDate(), schedule.getEndDate()).getId() != schedule.getId()) {
			throw new ScheduleInSamePeriodException();
		}

		scheduleFind.update(schedule);

		return scheduleJpaRepository.save(scheduleFind);
	}

	public List<Schedule> getAll() {
		return scheduleJpaRepository.findAll();
	}

	public Schedule findById(Long id) {

		Optional<Schedule> scheduleFind = scheduleJpaRepository.findById(id);
		if (!scheduleFind.isPresent()) {
			throw new ScheduleNotFoundException();
		}

		return scheduleFind.get();
	}

	private Schedule verifySamePeriod(Date startDate, Date endDate) {
		return scheduleJpaRepository.findBetweenRange(startDate, endDate);
	}

	public void deleteSchedule(Long id) {
		scheduleJpaRepository.delete(findById(id));
	}

	public void verifyPeriodLessThanOrSame(Date initDate, Date finalDate) {
		if (initDate.compareTo(finalDate) == 0) {
			throw new ScheduleSameTimeException();
		}

		if (initDate.getTime() > finalDate.getTime()) {
			throw new ScheduleEndPeriodBiggerException();
		}

	}

}
