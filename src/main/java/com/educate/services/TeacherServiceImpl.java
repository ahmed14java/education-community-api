package com.educate.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educate.domain.Teacher;
import com.educate.repository.ClassRoomRepository;
import com.educate.repository.TeacherRepository;

@Repository
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private ClassRoomRepository classRoomRepository;

	@Override
	public Iterable<Teacher> list() {
		Iterable<Teacher> teachers = teacherRepository.findAll();
		return teachers;
	}

	@Override
	@Transactional
	public Teacher create(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public Teacher get(Long id) {
		Teacher teacher = teacherRepository.findOne(id);
		return teacher;
	}

	@Override
	public Teacher update(Long id, Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public void delete(Long id) {
		teacherRepository.delete(id);

	}

}
