package com.educate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educate.domain.Teacher;
import com.educate.services.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Teacher> listTeacher() {
		Iterable<Teacher> teachers = teacherService.list();
		return teachers;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Teacher getTeacher(@PathVariable("id") Long id) {
		Teacher teacher = teacherService.get(id);
		return teacher;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Teacher createTeacher(@RequestBody Teacher teacher) {
		return teacherService.create(teacher);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable("id") Long id) {
		return teacherService.update(id, teacher);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteTeacher(@PathVariable("id") Long id) {
		teacherService.delete(id);
	}

}
