package com.educate.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educate.domain.Student;
import com.educate.exception.PostNotFoundException;
import com.educate.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Student> listStudents() {
		Iterable<Student> students = studentService.list();
		return students;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {
		return studentService.create(student);
	}

	@ExceptionHandler(PostNotFoundException.class)
	public void handlePostNotFound(PostNotFoundException exception, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}
}
