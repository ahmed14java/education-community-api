package com.educate.services;

import com.educate.domain.Teacher;

public interface TeacherService {

	Iterable<Teacher> list();

	Teacher create(Teacher teacher);

	Teacher get(Long id);

	Teacher update(Long id, Teacher teacher);

	void delete(Long id);
}
