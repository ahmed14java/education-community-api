package com.educate.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.educate.domain.Student;
import com.educate.repository.ClassRoomRepository;
import com.educate.repository.StudentRepository;

@Repository
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ClassRoomRepository classRoomRepository;

	@Override
	public Iterable<Student> list() {
		Iterable<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	@Transactional
	public Student create(Student student) {
		classRoomRepository.save(student.getClassRoom());
		return studentRepository.save(student);
	}

	@Override
	public Student get(Long id) {
		Student student = studentRepository.findOne(id);
		return student;
	}

	@Override
	public Student update(Long id, Student update) {
		Student student = studentRepository.findOne(id);
		if (update.getName() != null) {
			student.setName(update.getName());
		}
		return studentRepository.save(student);
	}

	@Override
	public void delete(Long id) {
		studentRepository.delete(id);

	}

}
