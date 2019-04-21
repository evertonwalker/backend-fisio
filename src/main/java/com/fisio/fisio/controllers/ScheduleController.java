package com.fisio.fisio.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fisio.fisio.model.Schedule;
import com.fisio.fisio.service.ScheduleService;

@RestController
@RequestMapping("api/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;

	@RequestMapping("/")
	public List<Schedule> getAll() {
		return scheduleService.getAll();
	}
	
	@RequestMapping("/{id}")
	public Schedule getFindById(@PathVariable Long id) {
		return scheduleService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Schedule insert(@RequestBody @Valid Schedule schedule) {
		return scheduleService.create(schedule);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Schedule update(@RequestBody @Valid Schedule schedule, @PathVariable Long id) {
		return scheduleService.update(schedule, id);
	}
	
	@DeleteMapping("/id")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		scheduleService.deleteSchedule(id);
	}
	

}
