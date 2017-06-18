package com.educate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.educate.domain.Attendance;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

	Attendance findByStudentId(Long id);
}
