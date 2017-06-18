package com.educate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educate.domain.Attendance;
import com.educate.services.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Attendance> listAttendance() {
		Iterable<Attendance> attendances = attendanceService.listAttendance();
		return attendances;
	}

	@RequestMapping(value = "/getByStudentId/{id}", method = RequestMethod.GET)
	public Attendance getByStudentId(@PathVariable("id") Long id) {
		Attendance attendance = attendanceService.getByStudentId(id);
		return attendance;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Attendance createAttendance(@RequestBody Attendance attendance) {
		return attendanceService.createAttendance(attendance);
	}
}
