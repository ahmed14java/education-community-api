package com.educate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educate.domain.Attendance;
import com.educate.repository.AttendanceRepository;
import com.educate.repository.StudentRepository;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceRepository attendanceRepository;

	@Autowired
	private StudentRepository studentRepository;

	public Iterable<Attendance> listAttendance() {
		Iterable<Attendance> attendances = attendanceRepository.findAll();
		return attendances;
	}

	public Attendance getByStudentId(Long id) {
		return attendanceRepository.findByStudentId(id);
	}

	public Attendance createAttendance(Attendance attendance) {
		studentRepository.save(attendance.getStudent());
		return attendanceRepository.save(attendance);
	}
}
