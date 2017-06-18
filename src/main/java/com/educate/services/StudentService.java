package com.educate.services;

import com.educate.domain.Student;

public interface StudentService {

	Iterable<Student> list();

	Student create(Student student);

	Student get(Long id);

	Student update(Long id, Student student);

	void delete(Long id);
}
